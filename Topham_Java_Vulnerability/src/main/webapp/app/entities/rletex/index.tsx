import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Rletex from './rletex';
import RletexDetail from './rletex-detail';
import RletexUpdate from './rletex-update';
import RletexDeleteDialog from './rletex-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={RletexUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={RletexUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={RletexDetail} />
      <ErrorBoundaryRoute path={match.url} component={Rletex} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={RletexDeleteDialog} />
  </>
);

export default Routes;
