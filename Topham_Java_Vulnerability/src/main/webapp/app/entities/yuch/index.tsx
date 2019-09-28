import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Yuch from './yuch';
import YuchDetail from './yuch-detail';
import YuchUpdate from './yuch-update';
import YuchDeleteDialog from './yuch-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={YuchUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={YuchUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={YuchDetail} />
      <ErrorBoundaryRoute path={match.url} component={Yuch} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={YuchDeleteDialog} />
  </>
);

export default Routes;
