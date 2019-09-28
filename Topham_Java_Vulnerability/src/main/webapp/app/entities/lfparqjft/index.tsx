import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Lfparqjft from './lfparqjft';
import LfparqjftDetail from './lfparqjft-detail';
import LfparqjftUpdate from './lfparqjft-update';
import LfparqjftDeleteDialog from './lfparqjft-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={LfparqjftUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={LfparqjftUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={LfparqjftDetail} />
      <ErrorBoundaryRoute path={match.url} component={Lfparqjft} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={LfparqjftDeleteDialog} />
  </>
);

export default Routes;
