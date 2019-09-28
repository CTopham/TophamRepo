import axios from 'axios';
import {
  parseHeaderForLinks,
  loadMoreDataWhenScrolled,
  ICrudGetAction,
  ICrudGetAllAction,
  ICrudPutAction,
  ICrudDeleteAction
} from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISycdotfbx, defaultValue } from 'app/shared/model/sycdotfbx.model';

export const ACTION_TYPES = {
  FETCH_SYCDOTFBX_LIST: 'sycdotfbx/FETCH_SYCDOTFBX_LIST',
  FETCH_SYCDOTFBX: 'sycdotfbx/FETCH_SYCDOTFBX',
  CREATE_SYCDOTFBX: 'sycdotfbx/CREATE_SYCDOTFBX',
  UPDATE_SYCDOTFBX: 'sycdotfbx/UPDATE_SYCDOTFBX',
  DELETE_SYCDOTFBX: 'sycdotfbx/DELETE_SYCDOTFBX',
  RESET: 'sycdotfbx/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISycdotfbx>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type SycdotfbxState = Readonly<typeof initialState>;

// Reducer

export default (state: SycdotfbxState = initialState, action): SycdotfbxState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SYCDOTFBX_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SYCDOTFBX):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SYCDOTFBX):
    case REQUEST(ACTION_TYPES.UPDATE_SYCDOTFBX):
    case REQUEST(ACTION_TYPES.DELETE_SYCDOTFBX):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SYCDOTFBX_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SYCDOTFBX):
    case FAILURE(ACTION_TYPES.CREATE_SYCDOTFBX):
    case FAILURE(ACTION_TYPES.UPDATE_SYCDOTFBX):
    case FAILURE(ACTION_TYPES.DELETE_SYCDOTFBX):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SYCDOTFBX_LIST):
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_SYCDOTFBX):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SYCDOTFBX):
    case SUCCESS(ACTION_TYPES.UPDATE_SYCDOTFBX):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SYCDOTFBX):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/sycdotfbxes';

// Actions

export const getEntities: ICrudGetAllAction<ISycdotfbx> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_SYCDOTFBX_LIST,
    payload: axios.get<ISycdotfbx>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ISycdotfbx> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SYCDOTFBX,
    payload: axios.get<ISycdotfbx>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISycdotfbx> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SYCDOTFBX,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<ISycdotfbx> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SYCDOTFBX,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISycdotfbx> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SYCDOTFBX,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
