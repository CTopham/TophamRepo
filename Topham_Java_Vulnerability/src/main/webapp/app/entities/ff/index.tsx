import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Ff from './ff';
import FfDetail from './ff-detail';
import FfUpdate from './ff-update';
import FfDeleteDialog from './ff-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={FfUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={FfUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={FfDetail} />
      <ErrorBoundaryRoute path={match.url} component={Ff} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={FfDeleteDialog} />
  </>
);

export default Routes;
