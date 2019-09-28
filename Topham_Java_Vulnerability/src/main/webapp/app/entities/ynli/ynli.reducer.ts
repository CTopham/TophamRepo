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

import { IYnli, defaultValue } from 'app/shared/model/ynli.model';

export const ACTION_TYPES = {
  FETCH_YNLI_LIST: 'ynli/FETCH_YNLI_LIST',
  FETCH_YNLI: 'ynli/FETCH_YNLI',
  CREATE_YNLI: 'ynli/CREATE_YNLI',
  UPDATE_YNLI: 'ynli/UPDATE_YNLI',
  DELETE_YNLI: 'ynli/DELETE_YNLI',
  RESET: 'ynli/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IYnli>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type YnliState = Readonly<typeof initialState>;

// Reducer

export default (state: YnliState = initialState, action): YnliState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_YNLI_LIST):
    case REQUEST(ACTION_TYPES.FETCH_YNLI):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_YNLI):
    case REQUEST(ACTION_TYPES.UPDATE_YNLI):
    case REQUEST(ACTION_TYPES.DELETE_YNLI):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_YNLI_LIST):
    case FAILURE(ACTION_TYPES.FETCH_YNLI):
    case FAILURE(ACTION_TYPES.CREATE_YNLI):
    case FAILURE(ACTION_TYPES.UPDATE_YNLI):
    case FAILURE(ACTION_TYPES.DELETE_YNLI):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_YNLI_LIST):
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_YNLI):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_YNLI):
    case SUCCESS(ACTION_TYPES.UPDATE_YNLI):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_YNLI):
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

const apiUrl = 'api/ynlis';

// Actions

export const getEntities: ICrudGetAllAction<IYnli> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_YNLI_LIST,
    payload: axios.get<IYnli>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IYnli> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_YNLI,
    payload: axios.get<IYnli>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IYnli> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_YNLI,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<IYnli> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_YNLI,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IYnli> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_YNLI,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
