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

import { IYuch, defaultValue } from 'app/shared/model/yuch.model';

export const ACTION_TYPES = {
  FETCH_YUCH_LIST: 'yuch/FETCH_YUCH_LIST',
  FETCH_YUCH: 'yuch/FETCH_YUCH',
  CREATE_YUCH: 'yuch/CREATE_YUCH',
  UPDATE_YUCH: 'yuch/UPDATE_YUCH',
  DELETE_YUCH: 'yuch/DELETE_YUCH',
  RESET: 'yuch/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IYuch>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type YuchState = Readonly<typeof initialState>;

// Reducer

export default (state: YuchState = initialState, action): YuchState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_YUCH_LIST):
    case REQUEST(ACTION_TYPES.FETCH_YUCH):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_YUCH):
    case REQUEST(ACTION_TYPES.UPDATE_YUCH):
    case REQUEST(ACTION_TYPES.DELETE_YUCH):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_YUCH_LIST):
    case FAILURE(ACTION_TYPES.FETCH_YUCH):
    case FAILURE(ACTION_TYPES.CREATE_YUCH):
    case FAILURE(ACTION_TYPES.UPDATE_YUCH):
    case FAILURE(ACTION_TYPES.DELETE_YUCH):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_YUCH_LIST):
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_YUCH):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_YUCH):
    case SUCCESS(ACTION_TYPES.UPDATE_YUCH):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_YUCH):
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

const apiUrl = 'api/yuches';

// Actions

export const getEntities: ICrudGetAllAction<IYuch> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_YUCH_LIST,
    payload: axios.get<IYuch>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IYuch> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_YUCH,
    payload: axios.get<IYuch>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IYuch> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_YUCH,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<IYuch> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_YUCH,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IYuch> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_YUCH,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
