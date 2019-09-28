import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './lfparqjft.reducer';
import { ILfparqjft } from 'app/shared/model/lfparqjft.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ILfparqjftDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class LfparqjftDetail extends React.Component<ILfparqjftDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { lfparqjftEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Lfparqjft [<b>{lfparqjftEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details" />
          <Button tag={Link} to="/entity/lfparqjft" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/lfparqjft/${lfparqjftEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ lfparqjft }: IRootState) => ({
  lfparqjftEntity: lfparqjft.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(LfparqjftDetail);
