import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Jsosxwzeps from './jsosxwzeps';
import JsosxwzepsDetail from './jsosxwzeps-detail';
import JsosxwzepsUpdate from './jsosxwzeps-update';
import JsosxwzepsDeleteDialog from './jsosxwzeps-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={JsosxwzepsUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={JsosxwzepsUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={JsosxwzepsDetail} />
      <ErrorBoundaryRoute path={match.url} component={Jsosxwzeps} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={JsosxwzepsDeleteDialog} />
  </>
);

export default Routes;
