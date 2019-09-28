import { combineReducers } from 'redux';
import { loadingBarReducer as loadingBar } from 'react-redux-loading-bar';

import authentication, { AuthenticationState } from './authentication';
import applicationProfile, { ApplicationProfileState } from './application-profile';

import administration, { AdministrationState } from 'app/modules/administration/administration.reducer';
import userManagement, { UserManagementState } from 'app/modules/administration/user-management/user-management.reducer';
import register, { RegisterState } from 'app/modules/account/register/register.reducer';
import activate, { ActivateState } from 'app/modules/account/activate/activate.reducer';
import password, { PasswordState } from 'app/modules/account/password/password.reducer';
import settings, { SettingsState } from 'app/modules/account/settings/settings.reducer';
import passwordReset, { PasswordResetState } from 'app/modules/account/password-reset/password-reset.reducer';
import sessions, { SessionsState } from 'app/modules/account/sessions/sessions.reducer';
// prettier-ignore
import rletex, {
  RletexState
} from 'app/entities/rletex/rletex.reducer';
// prettier-ignore
import yuch, {
  YuchState
} from 'app/entities/yuch/yuch.reducer';
// prettier-ignore
import cwgkt, {
  CwgktState
} from 'app/entities/cwgkt/cwgkt.reducer';
// prettier-ignore
import cf, {
  CfState
} from 'app/entities/cf/cf.reducer';
// prettier-ignore
import jsosxwzeps, {
  JsosxwzepsState
} from 'app/entities/jsosxwzeps/jsosxwzeps.reducer';
// prettier-ignore
import jhi, {
  JhiState
} from 'app/entities/jhi/jhi.reducer';
// prettier-ignore
import lfparqjft, {
  LfparqjftState
} from 'app/entities/lfparqjft/lfparqjft.reducer';
// prettier-ignore
import ff, {
  FfState
} from 'app/entities/ff/ff.reducer';
// prettier-ignore
import ynli, {
  YnliState
} from 'app/entities/ynli/ynli.reducer';
// prettier-ignore
import sycdotfbx, {
  SycdotfbxState
} from 'app/entities/sycdotfbx/sycdotfbx.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

export interface IRootState {
  readonly authentication: AuthenticationState;
  readonly applicationProfile: ApplicationProfileState;
  readonly administration: AdministrationState;
  readonly userManagement: UserManagementState;
  readonly register: RegisterState;
  readonly activate: ActivateState;
  readonly passwordReset: PasswordResetState;
  readonly password: PasswordState;
  readonly settings: SettingsState;
  readonly sessions: SessionsState;
  readonly rletex: RletexState;
  readonly yuch: YuchState;
  readonly cwgkt: CwgktState;
  readonly cf: CfState;
  readonly jsosxwzeps: JsosxwzepsState;
  readonly jhi: JhiState;
  readonly lfparqjft: LfparqjftState;
  readonly ff: FfState;
  readonly ynli: YnliState;
  readonly sycdotfbx: SycdotfbxState;
  /* jhipster-needle-add-reducer-type - JHipster will add reducer type here */
  readonly loadingBar: any;
}

const rootReducer = combineReducers<IRootState>({
  authentication,
  applicationProfile,
  administration,
  userManagement,
  register,
  activate,
  passwordReset,
  password,
  settings,
  sessions,
  rletex,
  yuch,
  cwgkt,
  cf,
  jsosxwzeps,
  jhi,
  lfparqjft,
  ff,
  ynli,
  sycdotfbx,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
  loadingBar
});

export default rootReducer;
