import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IJhi, defaultValue } from 'app/shared/model/jhi.model';

export const ACTION_TYPES = {
  FETCH_JHI_LIST: 'jhi/FETCH_JHI_LIST',
  FETCH_JHI: 'jhi/FETCH_JHI',
  CREATE_JHI: 'jhi/CREATE_JHI',
  UPDATE_JHI: 'jhi/UPDATE_JHI',
  DELETE_JHI: 'jhi/DELETE_JHI',
  RESET: 'jhi/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IJhi>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type JhiState = Readonly<typeof initialState>;

// Reducer

export default (state: JhiState = initialState, action): JhiState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_JHI_LIST):
    case REQUEST(ACTION_TYPES.FETCH_JHI):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_JHI):
    case REQUEST(ACTION_TYPES.UPDATE_JHI):
    case REQUEST(ACTION_TYPES.DELETE_JHI):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_JHI_LIST):
    case FAILURE(ACTION_TYPES.FETCH_JHI):
    case FAILURE(ACTION_TYPES.CREATE_JHI):
    case FAILURE(ACTION_TYPES.UPDATE_JHI):
    case FAILURE(ACTION_TYPES.DELETE_JHI):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHI_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_JHI):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_JHI):
    case SUCCESS(ACTION_TYPES.UPDATE_JHI):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_JHI):
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

const apiUrl = 'api/jhis';

// Actions

export const getEntities: ICrudGetAllAction<IJhi> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_JHI_LIST,
    payload: axios.get<IJhi>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IJhi> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_JHI,
    payload: axios.get<IJhi>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IJhi> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_JHI,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IJhi> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_JHI,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IJhi> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_JHI,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
