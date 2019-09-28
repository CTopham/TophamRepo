import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IFf, defaultValue } from 'app/shared/model/ff.model';

export const ACTION_TYPES = {
  FETCH_FF_LIST: 'ff/FETCH_FF_LIST',
  FETCH_FF: 'ff/FETCH_FF',
  CREATE_FF: 'ff/CREATE_FF',
  UPDATE_FF: 'ff/UPDATE_FF',
  DELETE_FF: 'ff/DELETE_FF',
  RESET: 'ff/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IFf>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type FfState = Readonly<typeof initialState>;

// Reducer

export default (state: FfState = initialState, action): FfState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_FF_LIST):
    case REQUEST(ACTION_TYPES.FETCH_FF):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_FF):
    case REQUEST(ACTION_TYPES.UPDATE_FF):
    case REQUEST(ACTION_TYPES.DELETE_FF):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_FF_LIST):
    case FAILURE(ACTION_TYPES.FETCH_FF):
    case FAILURE(ACTION_TYPES.CREATE_FF):
    case FAILURE(ACTION_TYPES.UPDATE_FF):
    case FAILURE(ACTION_TYPES.DELETE_FF):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_FF_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_FF):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_FF):
    case SUCCESS(ACTION_TYPES.UPDATE_FF):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_FF):
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

const apiUrl = 'api/ffs';

// Actions

export const getEntities: ICrudGetAllAction<IFf> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_FF_LIST,
    payload: axios.get<IFf>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IFf> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_FF,
    payload: axios.get<IFf>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IFf> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_FF,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IFf> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_FF,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IFf> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_FF,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
