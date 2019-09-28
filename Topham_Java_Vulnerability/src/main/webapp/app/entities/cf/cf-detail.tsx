import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './cf.reducer';
import { ICf } from 'app/shared/model/cf.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICfDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class CfDetail extends React.Component<ICfDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { cfEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Cf [<b>{cfEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="dszipjLILHDGEB">Dszipj LILHDGEB</span>
            </dt>
            <dd>{cfEntity.dszipjLILHDGEB}</dd>
            <dt>
              <span id="kxHFGGG">Kx HFGGG</span>
            </dt>
            <dd>{cfEntity.kxHFGGG}</dd>
            <dt>
              <span id="qjqNJ">Qjq NJ</span>
            </dt>
            <dd>{cfEntity.qjqNJ}</dd>
            <dt>
              <span id="uycdkngjyEX">Uycdkngjy EX</span>
            </dt>
            <dd>{cfEntity.uycdkngjyEX}</dd>
            <dt>
              <span id="lttzrsukkITST">Lttzrsukk ITST</span>
            </dt>
            <dd>{cfEntity.lttzrsukkITST}</dd>
            <dt>
              <span id="cwfYZVEIJKE">Cwf YZVEIJKE</span>
            </dt>
            <dd>{cfEntity.cwfYZVEIJKE}</dd>
            <dt>
              <span id="ywuhpryGC">Ywuhpry GC</span>
            </dt>
            <dd>
              <TextFormat value={cfEntity.ywuhpryGC} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="euhuyarMVMESJ">Euhuyar MVMESJ</span>
            </dt>
            <dd>
              <TextFormat value={cfEntity.euhuyarMVMESJ} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="zwbRBGEWZQDH">Zwb RBGEWZQDH</span>
            </dt>
            <dd>{cfEntity.zwbRBGEWZQDH}</dd>
            <dt>
              <span id="yjfmrsuugHRWGXNH">Yjfmrsuug HRWGXNH</span>
            </dt>
            <dd>
              <TextFormat value={cfEntity.yjfmrsuugHRWGXNH} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="cyLONPOURB">Cy LONPOURB</span>
            </dt>
            <dd>
              <TextFormat value={cfEntity.cyLONPOURB} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="tafphcQPQLPZB">Tafphc QPQLPZB</span>
            </dt>
            <dd>{cfEntity.tafphcQPQLPZB}</dd>
          </dl>
          <Button tag={Link} to="/entity/cf" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/cf/${cfEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ cf }: IRootState) => ({
  cfEntity: cf.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CfDetail);
