import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './rletex.reducer';
import { IRletex } from 'app/shared/model/rletex.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IRletexUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IRletexUpdateState {
  isNew: boolean;
}

export class RletexUpdate extends React.Component<IRletexUpdateProps, IRletexUpdateState> {
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
    values.xlkJZDTGUDMI = convertDateTimeToServer(values.xlkJZDTGUDMI);
    values.iGGLNXLDXS = convertDateTimeToServer(values.iGGLNXLDXS);

    if (errors.length === 0) {
      const { rletexEntity } = this.props;
      const entity = {
        ...rletexEntity,
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
    this.props.history.push('/entity/rletex');
  };

  render() {
    const { rletexEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.rletex.home.createOrEditLabel">Create or edit a Rletex</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : rletexEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="rletex-id">ID</Label>
                    <AvInput id="rletex-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="sroeihTIMOVOQHQLabel" check>
                    <AvInput id="rletex-sroeihTIMOVOQHQ" type="checkbox" className="form-control" name="sroeihTIMOVOQHQ" />
                    Sroeih TIMOVOQHQ
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="lczcjlHYBZKLabel" for="rletex-lczcjlHYBZK">
                    Lczcjl HYBZK
                  </Label>
                  <AvField id="rletex-lczcjlHYBZK" type="string" className="form-control" name="lczcjlHYBZK" />
                </AvGroup>
                <AvGroup>
                  <Label id="xlkJZDTGUDMILabel" for="rletex-xlkJZDTGUDMI">
                    Xlk JZDTGUDMI
                  </Label>
                  <AvInput
                    id="rletex-xlkJZDTGUDMI"
                    type="datetime-local"
                    className="form-control"
                    name="xlkJZDTGUDMI"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.rletexEntity.xlkJZDTGUDMI)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dhzewmhhMBLabel" for="rletex-dhzewmhhMB">
                    Dhzewmhh MB
                  </Label>
                  <AvField id="rletex-dhzewmhhMB" type="date" className="form-control" name="dhzewmhhMB" />
                </AvGroup>
                <AvGroup>
                  <Label id="clturNTLabel" for="rletex-clturNT">
                    Cltur NT
                  </Label>
                  <AvField id="rletex-clturNT" type="text" name="clturNT" />
                </AvGroup>
                <AvGroup>
                  <Label id="kwblADTZLabel" for="rletex-kwblADTZ">
                    Kwbl ADTZ
                  </Label>
                  <AvField id="rletex-kwblADTZ" type="string" className="form-control" name="kwblADTZ" />
                </AvGroup>
                <AvGroup>
                  <Label id="mqnwbGJXLabel" for="rletex-mqnwbGJX">
                    Mqnwb GJX
                  </Label>
                  <AvField id="rletex-mqnwbGJX" type="string" className="form-control" name="mqnwbGJX" />
                </AvGroup>
                <AvGroup>
                  <Label id="xOZIRLabel" check>
                    <AvInput id="rletex-xOZIR" type="checkbox" className="form-control" name="xOZIR" />X OZIR
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="vmqVLabel" for="rletex-vmqV">
                    Vmq V
                  </Label>
                  <AvField id="rletex-vmqV" type="text" name="vmqV" />
                </AvGroup>
                <AvGroup>
                  <Label id="iGGLNXLDXSLabel" for="rletex-iGGLNXLDXS">
                    I GGLNXLDXS
                  </Label>
                  <AvInput
                    id="rletex-iGGLNXLDXS"
                    type="datetime-local"
                    className="form-control"
                    name="iGGLNXLDXS"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.rletexEntity.iGGLNXLDXS)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="vksnruhcGXVIWCTLabel" check>
                    <AvInput id="rletex-vksnruhcGXVIWCT" type="checkbox" className="form-control" name="vksnruhcGXVIWCT" />
                    Vksnruhc GXVIWCT
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="munxnaYLabel" for="rletex-munxnaY">
                    Munxna Y
                  </Label>
                  <AvField id="rletex-munxnaY" type="string" className="form-control" name="munxnaY" />
                </AvGroup>
                <AvGroup>
                  <Label id="qihfHXRYLabel" for="rletex-qihfHXRY">
                    Qihf HXRY
                  </Label>
                  <AvField id="rletex-qihfHXRY" type="date" className="form-control" name="qihfHXRY" />
                </AvGroup>
                <AvGroup>
                  <Label id="dwfucglgXNDLabel" for="rletex-dwfucglgXND">
                    Dwfucglg XND
                  </Label>
                  <AvField id="rletex-dwfucglgXND" type="string" className="form-control" name="dwfucglgXND" />
                </AvGroup>
                <AvGroup>
                  <Label id="yoUNHREZTLGLabel" for="rletex-yoUNHREZTLG">
                    Yo UNHREZTLG
                  </Label>
                  <AvField id="rletex-yoUNHREZTLG" type="text" name="yoUNHREZTLG" />
                </AvGroup>
                <AvGroup>
                  <Label id="sytdERLabel" for="rletex-sytdER">
                    Sytd ER
                  </Label>
                  <AvField id="rletex-sytdER" type="text" name="sytdER" />
                </AvGroup>
                <AvGroup>
                  <Label id="zNBBBICYPLabel" for="rletex-zNBBBICYP">
                    Z NBBBICYP
                  </Label>
                  <AvField id="rletex-zNBBBICYP" type="text" name="zNBBBICYP" />
                </AvGroup>
                <AvGroup>
                  <Label id="ifotjfAWXJDJIFLabel" check>
                    <AvInput id="rletex-ifotjfAWXJDJIF" type="checkbox" className="form-control" name="ifotjfAWXJDJIF" />
                    Ifotjf AWXJDJIF
                  </Label>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/rletex" replace color="info">
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
  rletexEntity: storeState.rletex.entity,
  loading: storeState.rletex.loading,
  updating: storeState.rletex.updating,
  updateSuccess: storeState.rletex.updateSuccess
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
)(RletexUpdate);
