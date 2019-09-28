import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ICwgkt, defaultValue } from 'app/shared/model/cwgkt.model';

export const ACTION_TYPES = {
  FETCH_CWGKT_LIST: 'cwgkt/FETCH_CWGKT_LIST',
  FETCH_CWGKT: 'cwgkt/FETCH_CWGKT',
  CREATE_CWGKT: 'cwgkt/CREATE_CWGKT',
  UPDATE_CWGKT: 'cwgkt/UPDATE_CWGKT',
  DELETE_CWGKT: 'cwgkt/DELETE_CWGKT',
  RESET: 'cwgkt/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ICwgkt>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type CwgktState = Readonly<typeof initialState>;

// Reducer

export default (state: CwgktState = initialState, action): CwgktState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_CWGKT_LIST):
    case REQUEST(ACTION_TYPES.FETCH_CWGKT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_CWGKT):
    case REQUEST(ACTION_TYPES.UPDATE_CWGKT):
    case REQUEST(ACTION_TYPES.DELETE_CWGKT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_CWGKT_LIST):
    case FAILURE(ACTION_TYPES.FETCH_CWGKT):
    case FAILURE(ACTION_TYPES.CREATE_CWGKT):
    case FAILURE(ACTION_TYPES.UPDATE_CWGKT):
    case FAILURE(ACTION_TYPES.DELETE_CWGKT):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_CWGKT_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_CWGKT):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_CWGKT):
    case SUCCESS(ACTION_TYPES.UPDATE_CWGKT):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_CWGKT):
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

const apiUrl = 'api/cwgkts';

// Actions

export const getEntities: ICrudGetAllAction<ICwgkt> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_CWGKT_LIST,
    payload: axios.get<ICwgkt>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ICwgkt> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_CWGKT,
    payload: axios.get<ICwgkt>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ICwgkt> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_CWGKT,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ICwgkt> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_CWGKT,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ICwgkt> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_CWGKT,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
