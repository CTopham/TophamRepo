import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ILfparqjft, defaultValue } from 'app/shared/model/lfparqjft.model';

export const ACTION_TYPES = {
  FETCH_LFPARQJFT_LIST: 'lfparqjft/FETCH_LFPARQJFT_LIST',
  FETCH_LFPARQJFT: 'lfparqjft/FETCH_LFPARQJFT',
  CREATE_LFPARQJFT: 'lfparqjft/CREATE_LFPARQJFT',
  UPDATE_LFPARQJFT: 'lfparqjft/UPDATE_LFPARQJFT',
  DELETE_LFPARQJFT: 'lfparqjft/DELETE_LFPARQJFT',
  RESET: 'lfparqjft/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ILfparqjft>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type LfparqjftState = Readonly<typeof initialState>;

// Reducer

export default (state: LfparqjftState = initialState, action): LfparqjftState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_LFPARQJFT_LIST):
    case REQUEST(ACTION_TYPES.FETCH_LFPARQJFT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_LFPARQJFT):
    case REQUEST(ACTION_TYPES.UPDATE_LFPARQJFT):
    case REQUEST(ACTION_TYPES.DELETE_LFPARQJFT):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_LFPARQJFT_LIST):
    case FAILURE(ACTION_TYPES.FETCH_LFPARQJFT):
    case FAILURE(ACTION_TYPES.CREATE_LFPARQJFT):
    case FAILURE(ACTION_TYPES.UPDATE_LFPARQJFT):
    case FAILURE(ACTION_TYPES.DELETE_LFPARQJFT):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_LFPARQJFT_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_LFPARQJFT):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_LFPARQJFT):
    case SUCCESS(ACTION_TYPES.UPDATE_LFPARQJFT):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_LFPARQJFT):
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

const apiUrl = 'api/lfparqjfts';

// Actions

export const getEntities: ICrudGetAllAction<ILfparqjft> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_LFPARQJFT_LIST,
    payload: axios.get<ILfparqjft>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ILfparqjft> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_LFPARQJFT,
    payload: axios.get<ILfparqjft>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ILfparqjft> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_LFPARQJFT,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ILfparqjft> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_LFPARQJFT,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ILfparqjft> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_LFPARQJFT,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
