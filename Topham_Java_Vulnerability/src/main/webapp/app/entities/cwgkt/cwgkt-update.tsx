import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './cwgkt.reducer';
import { ICwgkt } from 'app/shared/model/cwgkt.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ICwgktUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ICwgktUpdateState {
  isNew: boolean;
}

export class CwgktUpdate extends React.Component<ICwgktUpdateProps, ICwgktUpdateState> {
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
    values.wjmkgOKZEHAMR = convertDateTimeToServer(values.wjmkgOKZEHAMR);
    values.hecwxJSYQPCP = convertDateTimeToServer(values.hecwxJSYQPCP);
    values.whmhgtjcfGVTDZE = convertDateTimeToServer(values.whmhgtjcfGVTDZE);

    if (errors.length === 0) {
      const { cwgktEntity } = this.props;
      const entity = {
        ...cwgktEntity,
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
    this.props.history.push('/entity/cwgkt');
  };

  render() {
    const { cwgktEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.cwgkt.home.createOrEditLabel">Create or edit a Cwgkt</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : cwgktEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="cwgkt-id">ID</Label>
                    <AvInput id="cwgkt-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="datqyrdSSUVSLLabel" for="cwgkt-datqyrdSSUVSL">
                    Datqyrd SSUVSL
                  </Label>
                  <AvField id="cwgkt-datqyrdSSUVSL" type="string" className="form-control" name="datqyrdSSUVSL" />
                </AvGroup>
                <AvGroup>
                  <Label id="xiuoesWMTOLabel" for="cwgkt-xiuoesWMTO">
                    Xiuoes WMTO
                  </Label>
                  <AvField id="cwgkt-xiuoesWMTO" type="text" name="xiuoesWMTO" />
                </AvGroup>
                <AvGroup>
                  <Label id="wjmkgOKZEHAMRLabel" for="cwgkt-wjmkgOKZEHAMR">
                    Wjmkg OKZEHAMR
                  </Label>
                  <AvInput
                    id="cwgkt-wjmkgOKZEHAMR"
                    type="datetime-local"
                    className="form-control"
                    name="wjmkgOKZEHAMR"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.cwgktEntity.wjmkgOKZEHAMR)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="iwppbNLabel" for="cwgkt-iwppbN">
                    Iwppb N
                  </Label>
                  <AvField id="cwgkt-iwppbN" type="text" name="iwppbN" />
                </AvGroup>
                <AvGroup>
                  <Label id="uwzPKALLabel" for="cwgkt-uwzPKAL">
                    Uwz PKAL
                  </Label>
                  <AvField id="cwgkt-uwzPKAL" type="date" className="form-control" name="uwzPKAL" />
                </AvGroup>
                <AvGroup>
                  <Label id="gjdZLabel" check>
                    <AvInput id="cwgkt-gjdZ" type="checkbox" className="form-control" name="gjdZ" />
                    Gjd Z
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="knYEODEXLabel" for="cwgkt-knYEODEX">
                    Kn YEODEX
                  </Label>
                  <AvField id="cwgkt-knYEODEX" type="string" className="form-control" name="knYEODEX" />
                </AvGroup>
                <AvGroup>
                  <Label id="hecwxJSYQPCPLabel" for="cwgkt-hecwxJSYQPCP">
                    Hecwx JSYQPCP
                  </Label>
                  <AvInput
                    id="cwgkt-hecwxJSYQPCP"
                    type="datetime-local"
                    className="form-control"
                    name="hecwxJSYQPCP"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.cwgktEntity.hecwxJSYQPCP)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="qiesctruzNQSQQFKXRLabel" for="cwgkt-qiesctruzNQSQQFKXR">
                    Qiesctruz NQSQQFKXR
                  </Label>
                  <AvField id="cwgkt-qiesctruzNQSQQFKXR" type="text" name="qiesctruzNQSQQFKXR" />
                </AvGroup>
                <AvGroup>
                  <Label id="ecstKPPENUELLabel" for="cwgkt-ecstKPPENUEL">
                    Ecst KPPENUEL
                  </Label>
                  <AvField id="cwgkt-ecstKPPENUEL" type="string" className="form-control" name="ecstKPPENUEL" />
                </AvGroup>
                <AvGroup>
                  <Label id="rygwcTQGLabel" for="cwgkt-rygwcTQG">
                    Rygwc TQG
                  </Label>
                  <AvField id="cwgkt-rygwcTQG" type="text" name="rygwcTQG" />
                </AvGroup>
                <AvGroup>
                  <Label id="zusrWLabel" check>
                    <AvInput id="cwgkt-zusrW" type="checkbox" className="form-control" name="zusrW" />
                    Zusr W
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="xmidVONELLabel" for="cwgkt-xmidVONEL">
                    Xmid VONEL
                  </Label>
                  <AvField id="cwgkt-xmidVONEL" type="string" className="form-control" name="xmidVONEL" />
                </AvGroup>
                <AvGroup>
                  <Label id="msolwyOWVLabel" for="cwgkt-msolwyOWV">
                    Msolwy OWV
                  </Label>
                  <AvField id="cwgkt-msolwyOWV" type="string" className="form-control" name="msolwyOWV" />
                </AvGroup>
                <AvGroup>
                  <Label id="oyepoAOIUCLabel" for="cwgkt-oyepoAOIUC">
                    Oyepo AOIUC
                  </Label>
                  <AvField id="cwgkt-oyepoAOIUC" type="string" className="form-control" name="oyepoAOIUC" />
                </AvGroup>
                <AvGroup>
                  <Label id="whmhgtjcfGVTDZELabel" for="cwgkt-whmhgtjcfGVTDZE">
                    Whmhgtjcf GVTDZE
                  </Label>
                  <AvInput
                    id="cwgkt-whmhgtjcfGVTDZE"
                    type="datetime-local"
                    className="form-control"
                    name="whmhgtjcfGVTDZE"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.cwgktEntity.whmhgtjcfGVTDZE)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="immakFGLabel" for="cwgkt-immakFG">
                    Immak FG
                  </Label>
                  <AvField id="cwgkt-immakFG" type="text" name="immakFG" />
                </AvGroup>
                <AvGroup>
                  <Label id="jbagfJNANLabel" for="cwgkt-jbagfJNAN">
                    Jbagf JNAN
                  </Label>
                  <AvField id="cwgkt-jbagfJNAN" type="string" className="form-control" name="jbagfJNAN" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/cwgkt" replace color="info">
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
  cwgktEntity: storeState.cwgkt.entity,
  loading: storeState.cwgkt.loading,
  updating: storeState.cwgkt.updating,
  updateSuccess: storeState.cwgkt.updateSuccess
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
)(CwgktUpdate);
