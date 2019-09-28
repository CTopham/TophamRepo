import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './jsosxwzeps.reducer';
import { IJsosxwzeps } from 'app/shared/model/jsosxwzeps.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IJsosxwzepsDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class JsosxwzepsDetail extends React.Component<IJsosxwzepsDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { jsosxwzepsEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Jsosxwzeps [<b>{jsosxwzepsEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="dcnzfaKVVGZ">Dcnzfa KVVGZ</span>
            </dt>
            <dd>{jsosxwzepsEntity.dcnzfaKVVGZ}</dd>
            <dt>
              <span id="wjuPKS">Wju PKS</span>
            </dt>
            <dd>{jsosxwzepsEntity.wjuPKS}</dd>
          </dl>
          <Button tag={Link} to="/entity/jsosxwzeps" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/jsosxwzeps/${jsosxwzepsEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ jsosxwzeps }: IRootState) => ({
  jsosxwzepsEntity: jsosxwzeps.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JsosxwzepsDetail);
