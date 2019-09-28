import React from 'react';
import { Switch } from 'react-router-dom';

// tslint:disable-next-line:no-unused-variable
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Rletex from './rletex';
import Yuch from './yuch';
import Cwgkt from './cwgkt';
import Cf from './cf';
import Jsosxwzeps from './jsosxwzeps';
import Jhi from './jhi';
import Lfparqjft from './lfparqjft';
import Ff from './ff';
import Ynli from './ynli';
import Sycdotfbx from './sycdotfbx';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}/rletex`} component={Rletex} />
      <ErrorBoundaryRoute path={`${match.url}/yuch`} component={Yuch} />
      <ErrorBoundaryRoute path={`${match.url}/cwgkt`} component={Cwgkt} />
      <ErrorBoundaryRoute path={`${match.url}/cf`} component={Cf} />
      <ErrorBoundaryRoute path={`${match.url}/jsosxwzeps`} component={Jsosxwzeps} />
      <ErrorBoundaryRoute path={`${match.url}/jhi`} component={Jhi} />
      <ErrorBoundaryRoute path={`${match.url}/lfparqjft`} component={Lfparqjft} />
      <ErrorBoundaryRoute path={`${match.url}/ff`} component={Ff} />
      <ErrorBoundaryRoute path={`${match.url}/ynli`} component={Ynli} />
      <ErrorBoundaryRoute path={`${match.url}/sycdotfbx`} component={Sycdotfbx} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
