import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './yuch.reducer';
import { IYuch } from 'app/shared/model/yuch.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IYuchUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IYuchUpdateState {
  isNew: boolean;
}

export class YuchUpdate extends React.Component<IYuchUpdateProps, IYuchUpdateState> {
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
    values.bjvdtahYZTHGS = convertDateTimeToServer(values.bjvdtahYZTHGS);
    values.ebdPPFKSZN = convertDateTimeToServer(values.ebdPPFKSZN);

    if (errors.length === 0) {
      const { yuchEntity } = this.props;
      const entity = {
        ...yuchEntity,
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
    this.props.history.push('/entity/yuch');
  };

  render() {
    const { yuchEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.yuch.home.createOrEditLabel">Create or edit a Yuch</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : yuchEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="yuch-id">ID</Label>
                    <AvInput id="yuch-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="qpswwvISLUJLabel" for="yuch-qpswwvISLUJ">
                    Qpswwv ISLUJ
                  </Label>
                  <AvField id="yuch-qpswwvISLUJ" type="string" className="form-control" name="qpswwvISLUJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="bjvdtahYZTHGSLabel" for="yuch-bjvdtahYZTHGS">
                    Bjvdtah YZTHGS
                  </Label>
                  <AvInput
                    id="yuch-bjvdtahYZTHGS"
                    type="datetime-local"
                    className="form-control"
                    name="bjvdtahYZTHGS"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.yuchEntity.bjvdtahYZTHGS)}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="xGUNULabel" for="yuch-xGUNU">
                    X GUNU
                  </Label>
                  <AvField id="yuch-xGUNU" type="string" className="form-control" name="xGUNU" />
                </AvGroup>
                <AvGroup>
                  <Label id="eSLabel" for="yuch-eS">
                    E S
                  </Label>
                  <AvField id="yuch-eS" type="text" name="eS" />
                </AvGroup>
                <AvGroup>
                  <Label id="sfSYLabel" for="yuch-sfSY">
                    Sf SY
                  </Label>
                  <AvField id="yuch-sfSY" type="string" className="form-control" name="sfSY" />
                </AvGroup>
                <AvGroup>
                  <Label id="kmrfRTQTZDLabel" for="yuch-kmrfRTQTZD">
                    Kmrf RTQTZD
                  </Label>
                  <AvField id="yuch-kmrfRTQTZD" type="string" className="form-control" name="kmrfRTQTZD" />
                </AvGroup>
                <AvGroup>
                  <Label id="ebdPPFKSZNLabel" for="yuch-ebdPPFKSZN">
                    Ebd PPFKSZN
                  </Label>
                  <AvInput
                    id="yuch-ebdPPFKSZN"
                    type="datetime-local"
                    className="form-control"
                    name="ebdPPFKSZN"
                    placeholder={'YYYY-MM-DD HH:mm'}
                    value={isNew ? null : convertDateTimeFromServer(this.props.yuchEntity.ebdPPFKSZN)}
                  />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/yuch" replace color="info">
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
  yuchEntity: storeState.yuch.entity,
  loading: storeState.yuch.loading,
  updating: storeState.yuch.updating,
  updateSuccess: storeState.yuch.updateSuccess
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
)(YuchUpdate);
