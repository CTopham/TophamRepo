import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './ynli.reducer';
import { IYnli } from 'app/shared/model/ynli.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IYnliUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IYnliUpdateState {
  isNew: boolean;
}

export class YnliUpdate extends React.Component<IYnliUpdateProps, IYnliUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (!this.state.isNew) {
      this.props.getEntity(this.props.match.params.id);
    }
  }

  saveEntity = (event, errors, values) => {
    values.yzajrxIAYDPK = convertDateTimeToServer(values.yzajrxIAYDPK);
    values.oIUPEEOQW = convertDateTimeToServer(values.oIUPEEOQW);
    values.hrluhfDTNWH = convertDateTimeToServer(values.hrluhfDTNWH);

    if (errors.length === 0) {
      const { ynliEntity } = this.props;
      const entity = {
        ...ynliEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/ynli');
  };

  render() {
    const { ynliEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.ynli.home.createOrEditLabel">Create or edit a Ynli</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : ynliEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="ynli-id">ID</Label>
                    <AvInput id="ynli-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="yzajrxIAYDPKLabel" for="ynli-yzajrxIAYDPK">
                    Yzajrx IAYDPK
                  </Label>
                  <AvInput
                    id="ynli-yzajrxIAYDPK"
                    type="datetime-local"
                    className="form-control"
                    name="yzajrxIAYDPK"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ynliEntity.yzajrxIAYDPK)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="fgvstxxhkBMQOISLabel" for="ynli-fgvstxxhkBMQOIS">
                    Fgvstxxhk BMQOIS
                  </Label>
                  <AvField id="ynli-fgvstxxhkBMQOIS" type="string" className="form-control" name="fgvstxxhkBMQOIS" />
                </AvGroup>
                <AvGroup>
                  <Label id="yhbmpkbhBYCNYLabel" for="ynli-yhbmpkbhBYCNY">
                    Yhbmpkbh BYCNY
                  </Label>
                  <AvField id="ynli-yhbmpkbhBYCNY" type="text" name="yhbmpkbhBYCNY" />
                </AvGroup>
                <AvGroup>
                  <Label id="mngKJLIMLabel" for="ynli-mngKJLIM">
                    Mng KJLIM
                  </Label>
                  <AvField id="ynli-mngKJLIM" type="date" className="form-control" name="mngKJLIM" />
                </AvGroup>
                <AvGroup>
                  <Label id="qbafFJWJZSBTLabel" for="ynli-qbafFJWJZSBT">
                    Qbaf FJWJZSBT
                  </Label>
                  <AvField id="ynli-qbafFJWJZSBT" type="date" className="form-control" name="qbafFJWJZSBT" />
                </AvGroup>
                <AvGroup>
                  <Label id="bxoqkppJHLGLabel" for="ynli-bxoqkppJHLG">
                    Bxoqkpp JHLG
                  </Label>
                  <AvField id="ynli-bxoqkppJHLG" type="string" className="form-control" name="bxoqkppJHLG" />
                </AvGroup>
                <AvGroup>
                  <Label id="smNLabel" for="ynli-smN">
                    Sm N
                  </Label>
                  <AvField id="ynli-smN" type="string" className="form-control" name="smN" />
                </AvGroup>
                <AvGroup>
                  <Label id="mrpzrywoEQQJOCFNLabel" for="ynli-mrpzrywoEQQJOCFN">
                    Mrpzrywo EQQJOCFN
                  </Label>
                  <AvField id="ynli-mrpzrywoEQQJOCFN" type="date" className="form-control" name="mrpzrywoEQQJOCFN" />
                </AvGroup>
                <AvGroup>
                  <Label id="anPRUYLabel" check>
                    <AvInput id="ynli-anPRUY" type="checkbox" className="form-control" name="anPRUY" />
                    An PRUY
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="rmwupkgmxEJPUWYXCDLabel" for="ynli-rmwupkgmxEJPUWYXCD">
                    Rmwupkgmx EJPUWYXCD
                  </Label>
                  <AvField id="ynli-rmwupkgmxEJPUWYXCD" type="date" className="form-control" name="rmwupkgmxEJPUWYXCD" />
                </AvGroup>
                <AvGroup>
                  <Label id="qsnxsihtZPGGTPLLabel" for="ynli-qsnxsihtZPGGTPL">
                    Qsnxsiht ZPGGTPL
                  </Label>
                  <AvField id="ynli-qsnxsihtZPGGTPL" type="text" name="qsnxsihtZPGGTPL" />
                </AvGroup>
                <AvGroup>
                  <Label id="fayZWWFLabel" for="ynli-fayZWWF">
                    Fay ZWWF
                  </Label>
                  <AvField id="ynli-fayZWWF" type="string" className="form-control" name="fayZWWF" />
                </AvGroup>
                <AvGroup>
                  <Label id="oIUPEEOQWLabel" for="ynli-oIUPEEOQW">
                    O IUPEEOQW
                  </Label>
                  <AvInput
                    id="ynli-oIUPEEOQW"
                    type="datetime-local"
                    className="form-control"
                    name="oIUPEEOQW"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ynliEntity.oIUPEEOQW)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="exicFFTTMLabel" for="ynli-exicFFTTM">
                    Exic FFTTM
                  </Label>
                  <AvField id="ynli-exicFFTTM" type="text" name="exicFFTTM" />
                </AvGroup>
                <AvGroup>
                  <Label id="hrluhfDTNWHLabel" for="ynli-hrluhfDTNWH">
                    Hrluhf DTNWH
                  </Label>
                  <AvInput
                    id="ynli-hrluhfDTNWH"
                    type="datetime-local"
                    className="form-control"
                    name="hrluhfDTNWH"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ynliEntity.hrluhfDTNWH)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="erwTLHLabel" for="ynli-erwTLH">
                    Erw TLH
                  </Label>
                  <AvField id="ynli-erwTLH" type="date" className="form-control" name="erwTLH" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/ynli" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />
                  &nbsp;
                  <span className="d-none d-md-inline">Back</span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />
                  &nbsp; Save
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  ynliEntity: storeState.ynli.entity,
  loading: storeState.ynli.loading,
  updating: storeState.ynli.updating,
  updateSuccess: storeState.ynli.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(YnliUpdate);
