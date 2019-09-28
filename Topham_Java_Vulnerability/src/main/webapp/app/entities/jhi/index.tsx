import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Jhi from './jhi';
import JhiDetail from './jhi-detail';
import JhiUpdate from './jhi-update';
import JhiDeleteDialog from './jhi-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JhiUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JhiUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JhiDetail} />
      <ErrorBoundaryRoute path={match.url} component={Jhi} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JhiDeleteDialog} />
  </>
);

export default Routes;
