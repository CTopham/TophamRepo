import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './jhi.reducer';
import { IJhi } from 'app/shared/model/jhi.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IJhiUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IJhiUpdateState {
  isNew: boolean;
}

export class JhiUpdate extends React.Component<IJhiUpdateProps, IJhiUpdateState> {
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
    values.ulorfvrzNGZQT = convertDateTimeToServer(values.ulorfvrzNGZQT);
    values.bebpxFFA = convertDateTimeToServer(values.bebpxFFA);

    if (errors.length === 0) {
      const { jhiEntity } = this.props;
      const entity = {
        ...jhiEntity,
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
    this.props.history.push('/entity/jhi');
  };

  render() {
    const { jhiEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.jhi.home.createOrEditLabel">Create or edit a Jhi</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : jhiEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="jhi-id">ID</Label>
                    <AvInput id="jhi-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="kuxgvrghgZWUVBASLabel" for="jhi-kuxgvrghgZWUVBAS">
                    Kuxgvrghg ZWUVBAS
                  </Label>
                  <AvField id="jhi-kuxgvrghgZWUVBAS" type="string" className="form-control" name="kuxgvrghgZWUVBAS" />
                </AvGroup>
                <AvGroup>
                  <Label id="cyoluqjxCCMPZMLabel" for="jhi-cyoluqjxCCMPZM">
                    Cyoluqjx CCMPZM
                  </Label>
                  <AvField id="jhi-cyoluqjxCCMPZM" type="string" className="form-control" name="cyoluqjxCCMPZM" />
                </AvGroup>
                <AvGroup>
                  <Label id="cGHPVLNPHGLabel" check>
                    <AvInput id="jhi-cGHPVLNPHG" type="checkbox" className="form-control" name="cGHPVLNPHG" />C GHPVLNPHG
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="fnsunJGEXYLabel" for="jhi-fnsunJGEXY">
                    Fnsun JGEXY
                  </Label>
                  <AvField id="jhi-fnsunJGEXY" type="string" className="form-control" name="fnsunJGEXY" />
                </AvGroup>
                <AvGroup>
                  <Label id="xfhMRAWOADLabel" for="jhi-xfhMRAWOAD">
                    Xfh MRAWOAD
                  </Label>
                  <AvField id="jhi-xfhMRAWOAD" type="string" className="form-control" name="xfhMRAWOAD" />
                </AvGroup>
                <AvGroup>
                  <Label id="rhcuagusEMLabel" for="jhi-rhcuagusEM">
                    Rhcuagus EM
                  </Label>
                  <AvField id="jhi-rhcuagusEM" type="text" name="rhcuagusEM" />
                </AvGroup>
                <AvGroup>
                  <Label id="nnmuicgOIILabel" for="jhi-nnmuicgOII">
                    Nnmuicg OII
                  </Label>
                  <AvField id="jhi-nnmuicgOII" type="string" className="form-control" name="nnmuicgOII" />
                </AvGroup>
                <AvGroup>
                  <Label id="cqCGPSOPJCLabel" for="jhi-cqCGPSOPJC">
                    Cq CGPSOPJC
                  </Label>
                  <AvField id="jhi-cqCGPSOPJC" type="string" className="form-control" name="cqCGPSOPJC" />
                </AvGroup>
                <AvGroup>
                  <Label id="ycWFMXXLabel" check>
                    <AvInput id="jhi-ycWFMXX" type="checkbox" className="form-control" name="ycWFMXX" />
                    Yc WFMXX
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="vIEFKCLJCNLabel" check>
                    <AvInput id="jhi-vIEFKCLJCN" type="checkbox" className="form-control" name="vIEFKCLJCN" />V IEFKCLJCN
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="ulorfvrzNGZQTLabel" for="jhi-ulorfvrzNGZQT">
                    Ulorfvrz NGZQT
                  </Label>
                  <AvInput
                    id="jhi-ulorfvrzNGZQT"
                    type="datetime-local"
                    className="form-control"
                    name="ulorfvrzNGZQT"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.jhiEntity.ulorfvrzNGZQT)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="sfbrwwuezNWHCMTLabel" for="jhi-sfbrwwuezNWHCMT">
                    Sfbrwwuez NWHCMT
                  </Label>
                  <AvField id="jhi-sfbrwwuezNWHCMT" type="string" className="form-control" name="sfbrwwuezNWHCMT" />
                </AvGroup>
                <AvGroup>
                  <Label id="ysmxlujouDKMEIUUGLabel" for="jhi-ysmxlujouDKMEIUUG">
                    Ysmxlujou DKMEIUUG
                  </Label>
                  <AvField id="jhi-ysmxlujouDKMEIUUG" type="string" className="form-control" name="ysmxlujouDKMEIUUG" />
                </AvGroup>
                <AvGroup>
                  <Label id="bebpxFFALabel" for="jhi-bebpxFFA">
                    Bebpx FFA
                  </Label>
                  <AvInput
                    id="jhi-bebpxFFA"
                    type="datetime-local"
                    className="form-control"
                    name="bebpxFFA"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.jhiEntity.bebpxFFA)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="fjiePMFLabel" for="jhi-fjiePMF">
                    Fjie PMF
                  </Label>
                  <AvField id="jhi-fjiePMF" type="text" name="fjiePMF" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/jhi" replace color="info">
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
  jhiEntity: storeState.jhi.entity,
  loading: storeState.jhi.loading,
  updating: storeState.jhi.updating,
  updateSuccess: storeState.jhi.updateSuccess
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
)(JhiUpdate);
