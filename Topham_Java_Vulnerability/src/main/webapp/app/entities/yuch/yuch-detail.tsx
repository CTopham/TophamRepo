import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './yuch.reducer';
import { IYuch } from 'app/shared/model/yuch.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IYuchDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class YuchDetail extends React.Component<IYuchDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { yuchEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Yuch [<b>{yuchEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="qpswwvISLUJ">Qpswwv ISLUJ</span>
            </dt>
            <dd>{yuchEntity.qpswwvISLUJ}</dd>
            <dt>
              <span id="bjvdtahYZTHGS">Bjvdtah YZTHGS</span>
            </dt>
            <dd>
              <TextFormat value={yuchEntity.bjvdtahYZTHGS} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="xGUNU">X GUNU</span>
            </dt>
            <dd>{yuchEntity.xGUNU}</dd>
            <dt>
              <span id="eS">E S</span>
            </dt>
            <dd>{yuchEntity.eS}</dd>
            <dt>
              <span id="sfSY">Sf SY</span>
            </dt>
            <dd>{yuchEntity.sfSY}</dd>
            <dt>
              <span id="kmrfRTQTZD">Kmrf RTQTZD</span>
            </dt>
            <dd>{yuchEntity.kmrfRTQTZD}</dd>
            <dt>
              <span id="ebdPPFKSZN">Ebd PPFKSZN</span>
            </dt>
            <dd>
              <TextFormat value={yuchEntity.ebdPPFKSZN} type="date" format={APP_DATE_FORMAT} />
            </dd>
          </dl>
          <Button tag={Link} to="/entity/yuch" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/yuch/${yuchEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ yuch }: IRootState) => ({
  yuchEntity: yuch.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(YuchDetail);
