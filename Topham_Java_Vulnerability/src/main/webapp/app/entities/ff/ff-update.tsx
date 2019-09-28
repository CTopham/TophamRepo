import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './ff.reducer';
import { IFf } from 'app/shared/model/ff.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IFfUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IFfUpdateState {
  isNew: boolean;
}

export class FfUpdate extends React.Component<IFfUpdateProps, IFfUpdateState> {
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
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }
  }

  saveEntity = (event, errors, values) => {
    values.urrW = convertDateTimeToServer(values.urrW);
    values.gffxRHSBKMA = convertDateTimeToServer(values.gffxRHSBKMA);
    values.wiBOYCMCRT = convertDateTimeToServer(values.wiBOYCMCRT);
    values.icwyavUN = convertDateTimeToServer(values.icwyavUN);

    if (errors.length === 0) {
      const { ffEntity } = this.props;
      const entity = {
        ...ffEntity,
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
    this.props.history.push('/entity/ff');
  };

  render() {
    const { ffEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.ff.home.createOrEditLabel">Create or edit a Ff</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : ffEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="ff-id">ID</Label>
                    <AvInput id="ff-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="urrWLabel" for="ff-urrW">
                    Urr W
                  </Label>
                  <AvInput
                    id="ff-urrW"
                    type="datetime-local"
                    className="form-control"
                    name="urrW"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ffEntity.urrW)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="nsjjklaGVGLLabel" for="ff-nsjjklaGVGL">
                    Nsjjkla GVGL
                  </Label>
                  <AvField id="ff-nsjjklaGVGL" type="date" className="form-control" name="nsjjklaGVGL" />
                </AvGroup>
                <AvGroup>
                  <Label id="gffxRHSBKMALabel" for="ff-gffxRHSBKMA">
                    Gffx RHSBKMA
                  </Label>
                  <AvInput
                    id="ff-gffxRHSBKMA"
                    type="datetime-local"
                    className="form-control"
                    name="gffxRHSBKMA"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ffEntity.gffxRHSBKMA)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="myqaeMLabel" for="ff-myqaeM">
                    Myqae M
                  </Label>
                  <AvField id="ff-myqaeM" type="text" name="myqaeM" />
                </AvGroup>
                <AvGroup>
                  <Label id="aovBRJLabel" for="ff-aovBRJ">
                    Aov BRJ
                  </Label>
                  <AvField id="ff-aovBRJ" type="text" name="aovBRJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="mvcoQBLabel" for="ff-mvcoQB">
                    Mvco QB
                  </Label>
                  <AvField id="ff-mvcoQB" type="string" className="form-control" name="mvcoQB" />
                </AvGroup>
                <AvGroup>
                  <Label id="xcwhaeeZLabel" for="ff-xcwhaeeZ">
                    Xcwhaee Z
                  </Label>
                  <AvField id="ff-xcwhaeeZ" type="string" className="form-control" name="xcwhaeeZ" />
                </AvGroup>
                <AvGroup>
                  <Label id="jzrnmeTZSROLabel" for="ff-jzrnmeTZSRO">
                    Jzrnme TZSRO
                  </Label>
                  <AvField id="ff-jzrnmeTZSRO" type="string" className="form-control" name="jzrnmeTZSRO" />
                </AvGroup>
                <AvGroup>
                  <Label id="wiBOYCMCRTLabel" for="ff-wiBOYCMCRT">
                    Wi BOYCMCRT
                  </Label>
                  <AvInput
                    id="ff-wiBOYCMCRT"
                    type="datetime-local"
                    className="form-control"
                    name="wiBOYCMCRT"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ffEntity.wiBOYCMCRT)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="jdrBMJZYTEWELabel" for="ff-jdrBMJZYTEWE">
                    Jdr BMJZYTEWE
                  </Label>
                  <AvField id="ff-jdrBMJZYTEWE" type="string" className="form-control" name="jdrBMJZYTEWE" />
                </AvGroup>
                <AvGroup>
                  <Label id="gmhZYXPBZLabel" for="ff-gmhZYXPBZ">
                    Gmh ZYXPBZ
                  </Label>
                  <AvField id="ff-gmhZYXPBZ" type="string" className="form-control" name="gmhZYXPBZ" />
                </AvGroup>
                <AvGroup>
                  <Label id="iGIGVIBXJRLabel" for="ff-iGIGVIBXJR">
                    I GIGVIBXJR
                  </Label>
                  <AvField id="ff-iGIGVIBXJR" type="date" className="form-control" name="iGIGVIBXJR" />
                </AvGroup>
                <AvGroup>
                  <Label id="fmfiCDTFJLBLabel" for="ff-fmfiCDTFJLB">
                    Fmfi CDTFJLB
                  </Label>
                  <AvField id="ff-fmfiCDTFJLB" type="string" className="form-control" name="fmfiCDTFJLB" />
                </AvGroup>
                <AvGroup>
                  <Label id="ylufADJLabel" for="ff-ylufADJ">
                    Yluf ADJ
                  </Label>
                  <AvField id="ff-ylufADJ" type="text" name="ylufADJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="pgnatCDLabel" for="ff-pgnatCD">
                    Pgnat CD
                  </Label>
                  <AvField id="ff-pgnatCD" type="date" className="form-control" name="pgnatCD" />
                </AvGroup>
                <AvGroup>
                  <Label id="icwyavUNLabel" for="ff-icwyavUN">
                    Icwyav UN
                  </Label>
                  <AvInput
                    id="ff-icwyavUN"
                    type="datetime-local"
                    className="form-control"
                    name="icwyavUN"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.ffEntity.icwyavUN)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="mfjkCWSHLabel" for="ff-mfjkCWSH">
                    Mfjk CWSH
                  </Label>
                  <AvField id="ff-mfjkCWSH" type="string" className="form-control" name="mfjkCWSH" />
                </AvGroup>
                <AvGroup>
                  <Label id="wdufNKFKFLabel" for="ff-wdufNKFKF">
                    Wduf NKFKF
                  </Label>
                  <AvField id="ff-wdufNKFKF" type="string" className="form-control" name="wdufNKFKF" />
                </AvGroup>
                <AvGroup>
                  <Label id="tyuboofZLWKPXLabel" check>
                    <AvInput id="ff-tyuboofZLWKPX" type="checkbox" className="form-control" name="tyuboofZLWKPX" />
                    Tyuboof ZLWKPX
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="bCGBSOAHLabel" for="ff-bCGBSOAH">
                    B CGBSOAH
                  </Label>
                  <AvField id="ff-bCGBSOAH" type="text" name="bCGBSOAH" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/ff" replace color="info">
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
  ffEntity: storeState.ff.entity,
  loading: storeState.ff.loading,
  updating: storeState.ff.updating,
  updateSuccess: storeState.ff.updateSuccess
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
)(FfUpdate);
