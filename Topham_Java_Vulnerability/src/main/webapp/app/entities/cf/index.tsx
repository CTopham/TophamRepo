import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Cf from './cf';
import CfDetail from './cf-detail';
import CfUpdate from './cf-update';
import CfDeleteDialog from './cf-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={CfUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={CfUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={CfDetail} />
      <ErrorBoundaryRoute path={match.url} component={Cf} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={CfDeleteDialog} />
  </>
);

export default Routes;
