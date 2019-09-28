import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Cwgkt from './cwgkt';
import CwgktDetail from './cwgkt-detail';
import CwgktUpdate from './cwgkt-update';
import CwgktDeleteDialog from './cwgkt-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={CwgktUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={CwgktUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={CwgktDetail} />
      <ErrorBoundaryRoute path={match.url} component={Cwgkt} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={CwgktDeleteDialog} />
  </>
);

export default Routes;
