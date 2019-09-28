import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './cf.reducer';
import { ICf } from 'app/shared/model/cf.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ICfUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ICfUpdateState {
  isNew: boolean;
}

export class CfUpdate extends React.Component<ICfUpdateProps, ICfUpdateState> {
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
    values.ywuhpryGC = convertDateTimeToServer(values.ywuhpryGC);
    values.euhuyarMVMESJ = convertDateTimeToServer(values.euhuyarMVMESJ);

    if (errors.length === 0) {
      const { cfEntity } = this.props;
      const entity = {
        ...cfEntity,
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
    this.props.history.push('/entity/cf');
  };

  render() {
    const { cfEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.cf.home.createOrEditLabel">Create or edit a Cf</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : cfEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="cf-id">ID</Label>
                    <AvInput id="cf-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="dszipjLILHDGEBLabel" for="cf-dszipjLILHDGEB">
                    Dszipj LILHDGEB
                  </Label>
                  <AvField id="cf-dszipjLILHDGEB" type="string" className="form-control" name="dszipjLILHDGEB" />
                </AvGroup>
                <AvGroup>
                  <Label id="kxHFGGGLabel" for="cf-kxHFGGG">
                    Kx HFGGG
                  </Label>
                  <AvField id="cf-kxHFGGG" type="string" className="form-control" name="kxHFGGG" />
                </AvGroup>
                <AvGroup>
                  <Label id="qjqNJLabel" for="cf-qjqNJ">
                    Qjq NJ
                  </Label>
                  <AvField id="cf-qjqNJ" type="text" name="qjqNJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="uycdkngjyEXLabel" for="cf-uycdkngjyEX">
                    Uycdkngjy EX
                  </Label>
                  <AvField id="cf-uycdkngjyEX" type="text" name="uycdkngjyEX" />
                </AvGroup>
                <AvGroup>
                  <Label id="lttzrsukkITSTLabel" for="cf-lttzrsukkITST">
                    Lttzrsukk ITST
                  </Label>
                  <AvField id="cf-lttzrsukkITST" type="string" className="form-control" name="lttzrsukkITST" />
                </AvGroup>
                <AvGroup>
                  <Label id="cwfYZVEIJKELabel" for="cf-cwfYZVEIJKE">
                    Cwf YZVEIJKE
                  </Label>
                  <AvField id="cf-cwfYZVEIJKE" type="string" className="form-control" name="cwfYZVEIJKE" />
                </AvGroup>
                <AvGroup>
                  <Label id="ywuhpryGCLabel" for="cf-ywuhpryGC">
                    Ywuhpry GC
                  </Label>
                  <AvInput
                    id="cf-ywuhpryGC"
                    type="datetime-local"
                    className="form-control"
                    name="ywuhpryGC"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.cfEntity.ywuhpryGC)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="euhuyarMVMESJLabel" for="cf-euhuyarMVMESJ">
                    Euhuyar MVMESJ
                  </Label>
                  <AvInput
                    id="cf-euhuyarMVMESJ"
                    type="datetime-local"
                    className="form-control"
                    name="euhuyarMVMESJ"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.cfEntity.euhuyarMVMESJ)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="zwbRBGEWZQDHLabel" for="cf-zwbRBGEWZQDH">
                    Zwb RBGEWZQDH
                  </Label>
                  <AvField id="cf-zwbRBGEWZQDH" type="text" name="zwbRBGEWZQDH" />
                </AvGroup>
                <AvGroup>
                  <Label id="yjfmrsuugHRWGXNHLabel" for="cf-yjfmrsuugHRWGXNH">
                    Yjfmrsuug HRWGXNH
                  </Label>
                  <AvField id="cf-yjfmrsuugHRWGXNH" type="date" className="form-control" name="yjfmrsuugHRWGXNH" />
                </AvGroup>
                <AvGroup>
                  <Label id="cyLONPOURBLabel" for="cf-cyLONPOURB">
                    Cy LONPOURB
                  </Label>
                  <AvField id="cf-cyLONPOURB" type="date" className="form-control" name="cyLONPOURB" />
                </AvGroup>
                <AvGroup>
                  <Label id="tafphcQPQLPZBLabel" for="cf-tafphcQPQLPZB">
                    Tafphc QPQLPZB
                  </Label>
                  <AvField id="cf-tafphcQPQLPZB" type="string" className="form-control" name="tafphcQPQLPZB" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/cf" replace color="info">
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
  cfEntity: storeState.cf.entity,
  loading: storeState.cf.loading,
  updating: storeState.cf.updating,
  updateSuccess: storeState.cf.updateSuccess
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
)(CfUpdate);
