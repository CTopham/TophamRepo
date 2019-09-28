import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './sycdotfbx.reducer';
import { ISycdotfbx } from 'app/shared/model/sycdotfbx.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ISycdotfbxUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ISycdotfbxUpdateState {
  isNew: boolean;
}

export class SycdotfbxUpdate extends React.Component<ISycdotfbxUpdateProps, ISycdotfbxUpdateState> {
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
    values.ylooxrwCAVWCFSFJ = convertDateTimeToServer(values.ylooxrwCAVWCFSFJ);
    values.bebohaanSNOHCG = convertDateTimeToServer(values.bebohaanSNOHCG);
    values.srTDOBHW = convertDateTimeToServer(values.srTDOBHW);
    values.mDPGGK = convertDateTimeToServer(values.mDPGGK);
    values.dgbhxwtLLL = convertDateTimeToServer(values.dgbhxwtLLL);
    values.fbdigDZKP = convertDateTimeToServer(values.fbdigDZKP);

    if (errors.length === 0) {
      const { sycdotfbxEntity } = this.props;
      const entity = {
        ...sycdotfbxEntity,
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
    this.props.history.push('/entity/sycdotfbx');
  };

  render() {
    const { sycdotfbxEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.sycdotfbx.home.createOrEditLabel">Create or edit a Sycdotfbx</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : sycdotfbxEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="sycdotfbx-id">ID</Label>
                    <AvInput id="sycdotfbx-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="uoerqrWHAVSPOYLabel" for="sycdotfbx-uoerqrWHAVSPOY">
                    Uoerqr WHAVSPOY
                  </Label>
                  <AvField id="sycdotfbx-uoerqrWHAVSPOY" type="text" name="uoerqrWHAVSPOY" />
                </AvGroup>
                <AvGroup>
                  <Label id="vtoeablliMPKLabel" for="sycdotfbx-vtoeablliMPK">
                    Vtoeablli MPK
                  </Label>
                  <AvField id="sycdotfbx-vtoeablliMPK" type="string" className="form-control" name="vtoeablliMPK" />
                </AvGroup>
                <AvGroup>
                  <Label id="gvAUAOKYBWNLabel" for="sycdotfbx-gvAUAOKYBWN">
                    Gv AUAOKYBWN
                  </Label>
                  <AvField id="sycdotfbx-gvAUAOKYBWN" type="text" name="gvAUAOKYBWN" />
                </AvGroup>
                <AvGroup>
                  <Label id="ylooxrwCAVWCFSFJLabel" for="sycdotfbx-ylooxrwCAVWCFSFJ">
                    Ylooxrw CAVWCFSFJ
                  </Label>
                  <AvInput
                    id="sycdotfbx-ylooxrwCAVWCFSFJ"
                    type="datetime-local"
                    className="form-control"
                    name="ylooxrwCAVWCFSFJ"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.ylooxrwCAVWCFSFJ)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="bebohaanSNOHCGLabel" for="sycdotfbx-bebohaanSNOHCG">
                    Bebohaan SNOHCG
                  </Label>
                  <AvInput
                    id="sycdotfbx-bebohaanSNOHCG"
                    type="datetime-local"
                    className="form-control"
                    name="bebohaanSNOHCG"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.bebohaanSNOHCG)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="phnagMUIFEGYLabel" for="sycdotfbx-phnagMUIFEGY">
                    Phnag MUIFEGY
                  </Label>
                  <AvField id="sycdotfbx-phnagMUIFEGY" type="text" name="phnagMUIFEGY" />
                </AvGroup>
                <AvGroup>
                  <Label id="mndiozSZGLabel" check>
                    <AvInput id="sycdotfbx-mndiozSZG" type="checkbox" className="form-control" name="mndiozSZG" />
                    Mndioz SZG
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="srTDOBHWLabel" for="sycdotfbx-srTDOBHW">
                    Sr TDOBHW
                  </Label>
                  <AvInput
                    id="sycdotfbx-srTDOBHW"
                    type="datetime-local"
                    className="form-control"
                    name="srTDOBHW"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.srTDOBHW)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="oqhtblwuLMTRLPZMSLabel" for="sycdotfbx-oqhtblwuLMTRLPZMS">
                    Oqhtblwu LMTRLPZMS
                  </Label>
                  <AvField id="sycdotfbx-oqhtblwuLMTRLPZMS" type="string" className="form-control" name="oqhtblwuLMTRLPZMS" />
                </AvGroup>
                <AvGroup>
                  <Label id="mDPGGKLabel" for="sycdotfbx-mDPGGK">
                    M DPGGK
                  </Label>
                  <AvInput
                    id="sycdotfbx-mDPGGK"
                    type="datetime-local"
                    className="form-control"
                    name="mDPGGK"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.mDPGGK)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dgbhxwtLLLLabel" for="sycdotfbx-dgbhxwtLLL">
                    Dgbhxwt LLL
                  </Label>
                  <AvInput
                    id="sycdotfbx-dgbhxwtLLL"
                    type="datetime-local"
                    className="form-control"
                    name="dgbhxwtLLL"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.dgbhxwtLLL)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="bqguzoagvFCZVLabel" for="sycdotfbx-bqguzoagvFCZV">
                    Bqguzoagv FCZV
                  </Label>
                  <AvField id="sycdotfbx-bqguzoagvFCZV" type="text" name="bqguzoagvFCZV" />
                </AvGroup>
                <AvGroup>
                  <Label id="jqwompJVQHLabel" for="sycdotfbx-jqwompJVQH">
                    Jqwomp JVQH
                  </Label>
                  <AvField id="sycdotfbx-jqwompJVQH" type="text" name="jqwompJVQH" />
                </AvGroup>
                <AvGroup>
                  <Label id="kIMVKQBLLabel" for="sycdotfbx-kIMVKQBL">
                    K IMVKQBL
                  </Label>
                  <AvField id="sycdotfbx-kIMVKQBL" type="text" name="kIMVKQBL" />
                </AvGroup>
                <AvGroup>
                  <Label id="uteAXHLSHLabel" for="sycdotfbx-uteAXHLSH">
                    Ute AXHLSH
                  </Label>
                  <AvField id="sycdotfbx-uteAXHLSH" type="string" className="form-control" name="uteAXHLSH" />
                </AvGroup>
                <AvGroup>
                  <Label id="nntcpjSMOPWFJYLabel" for="sycdotfbx-nntcpjSMOPWFJY">
                    Nntcpj SMOPWFJY
                  </Label>
                  <AvField id="sycdotfbx-nntcpjSMOPWFJY" type="text" name="nntcpjSMOPWFJY" />
                </AvGroup>
                <AvGroup>
                  <Label id="vfxsoygABWPMSUQULabel" for="sycdotfbx-vfxsoygABWPMSUQU">
                    Vfxsoyg ABWPMSUQU
                  </Label>
                  <AvField id="sycdotfbx-vfxsoygABWPMSUQU" type="text" name="vfxsoygABWPMSUQU" />
                </AvGroup>
                <AvGroup>
                  <Label id="fbdigDZKPLabel" for="sycdotfbx-fbdigDZKP">
                    Fbdig DZKP
                  </Label>
                  <AvInput
                    id="sycdotfbx-fbdigDZKP"
                    type="datetime-local"
                    className="form-control"
                    name="fbdigDZKP"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.sycdotfbxEntity.fbdigDZKP)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="vigcCOZMNLabel" for="sycdotfbx-vigcCOZMN">
                    Vigc COZMN
                  </Label>
                  <AvField id="sycdotfbx-vigcCOZMN" type="string" className="form-control" name="vigcCOZMN" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/sycdotfbx" replace color="info">
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
  sycdotfbxEntity: storeState.sycdotfbx.entity,
  loading: storeState.sycdotfbx.loading,
  updating: storeState.sycdotfbx.updating,
  updateSuccess: storeState.sycdotfbx.updateSuccess
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
)(SycdotfbxUpdate);
