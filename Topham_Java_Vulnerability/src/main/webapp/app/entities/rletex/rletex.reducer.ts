import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IRletex, defaultValue } from 'app/shared/model/rletex.model';

export const ACTION_TYPES = {
  FETCH_RLETEX_LIST: 'rletex/FETCH_RLETEX_LIST',
  FETCH_RLETEX: 'rletex/FETCH_RLETEX',
  CREATE_RLETEX: 'rletex/CREATE_RLETEX',
  UPDATE_RLETEX: 'rletex/UPDATE_RLETEX',
  DELETE_RLETEX: 'rletex/DELETE_RLETEX',
  RESET: 'rletex/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IRletex>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type RletexState = Readonly<typeof initialState>;

// Reducer

export default (state: RletexState = initialState, action): RletexState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_RLETEX_LIST):
    case REQUEST(ACTION_TYPES.FETCH_RLETEX):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_RLETEX):
    case REQUEST(ACTION_TYPES.UPDATE_RLETEX):
    case REQUEST(ACTION_TYPES.DELETE_RLETEX):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_RLETEX_LIST):
    case FAILURE(ACTION_TYPES.FETCH_RLETEX):
    case FAILURE(ACTION_TYPES.CREATE_RLETEX):
    case FAILURE(ACTION_TYPES.UPDATE_RLETEX):
    case FAILURE(ACTION_TYPES.DELETE_RLETEX):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_RLETEX_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_RLETEX):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_RLETEX):
    case SUCCESS(ACTION_TYPES.UPDATE_RLETEX):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_RLETEX):
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

const apiUrl = 'api/rletexes';

// Actions

export const getEntities: ICrudGetAllAction<IRletex> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_RLETEX_LIST,
    payload: axios.get<IRletex>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IRletex> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_RLETEX,
    payload: axios.get<IRletex>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IRletex> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_RLETEX,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IRletex> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_RLETEX,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IRletex> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_RLETEX,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
