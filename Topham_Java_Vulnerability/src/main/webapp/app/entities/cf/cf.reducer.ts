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

import { ICf, defaultValue } from 'app/shared/model/cf.model';

export const ACTION_TYPES = {
  FETCH_CF_LIST: 'cf/FETCH_CF_LIST',
  FETCH_CF: 'cf/FETCH_CF',
  CREATE_CF: 'cf/CREATE_CF',
  UPDATE_CF: 'cf/UPDATE_CF',
  DELETE_CF: 'cf/DELETE_CF',
  RESET: 'cf/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ICf>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type CfState = Readonly<typeof initialState>;

// Reducer

export default (state: CfState = initialState, action): CfState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_CF_LIST):
    case REQUEST(ACTION_TYPES.FETCH_CF):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_CF):
    case REQUEST(ACTION_TYPES.UPDATE_CF):
    case REQUEST(ACTION_TYPES.DELETE_CF):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_CF_LIST):
    case FAILURE(ACTION_TYPES.FETCH_CF):
    case FAILURE(ACTION_TYPES.CREATE_CF):
    case FAILURE(ACTION_TYPES.UPDATE_CF):
    case FAILURE(ACTION_TYPES.DELETE_CF):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_CF_LIST):
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_CF):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_CF):
    case SUCCESS(ACTION_TYPES.UPDATE_CF):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_CF):
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

const apiUrl = 'api/cfs';

// Actions

export const getEntities: ICrudGetAllAction<ICf> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_CF_LIST,
    payload: axios.get<ICf>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ICf> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_CF,
    payload: axios.get<ICf>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ICf> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_CF,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<ICf> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_CF,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<ICf> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_CF,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
