import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Sycdotfbx from './sycdotfbx';
import SycdotfbxDetail from './sycdotfbx-detail';
import SycdotfbxUpdate from './sycdotfbx-update';
import SycdotfbxDeleteDialog from './sycdotfbx-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SycdotfbxUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SycdotfbxUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SycdotfbxDetail} />
      <ErrorBoundaryRoute path={match.url} component={Sycdotfbx} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={SycdotfbxDeleteDialog} />
  </>
);

export default Routes;
