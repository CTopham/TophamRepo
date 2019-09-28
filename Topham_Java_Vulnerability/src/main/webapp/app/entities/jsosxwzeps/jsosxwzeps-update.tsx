import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './jsosxwzeps.reducer';
import { IJsosxwzeps } from 'app/shared/model/jsosxwzeps.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IJsosxwzepsUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IJsosxwzepsUpdateState {
  isNew: boolean;
}

export class JsosxwzepsUpdate extends React.Component<IJsosxwzepsUpdateProps, IJsosxwzepsUpdateState> {
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
    if (errors.length === 0) {
      const { jsosxwzepsEntity } = this.props;
      const entity = {
        ...jsosxwzepsEntity,
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
    this.props.history.push('/entity/jsosxwzeps');
  };

  render() {
    const { jsosxwzepsEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="zjqabApp.jsosxwzeps.home.createOrEditLabel">Create or edit a Jsosxwzeps</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : jsosxwzepsEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="jsosxwzeps-id">ID</Label>
                    <AvInput id="jsosxwzeps-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="dcnzfaKVVGZLabel" for="jsosxwzeps-dcnzfaKVVGZ">
                    Dcnzfa KVVGZ
                  </Label>
                  <AvField id="jsosxwzeps-dcnzfaKVVGZ" type="string" className="form-control" name="dcnzfaKVVGZ" />
                </AvGroup>
                <AvGroup>
                  <Label id="wjuPKSLabel" for="jsosxwzeps-wjuPKS">
                    Wju PKS
                  </Label>
                  <AvField id="jsosxwzeps-wjuPKS" type="text" name="wjuPKS" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/jsosxwzeps" replace color="info">
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
  jsosxwzepsEntity: storeState.jsosxwzeps.entity,
  loading: storeState.jsosxwzeps.loading,
  updating: storeState.jsosxwzeps.updating,
  updateSuccess: storeState.jsosxwzeps.updateSuccess
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
)(JsosxwzepsUpdate);
