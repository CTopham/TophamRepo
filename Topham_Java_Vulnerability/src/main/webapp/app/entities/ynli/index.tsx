import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Ynli from './ynli';
import YnliDetail from './ynli-detail';
import YnliUpdate from './ynli-update';
import YnliDeleteDialog from './ynli-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={YnliUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={YnliUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={YnliDetail} />
      <ErrorBoundaryRoute path={match.url} component={Ynli} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={YnliDeleteDialog} />
  </>
);

export default Routes;
