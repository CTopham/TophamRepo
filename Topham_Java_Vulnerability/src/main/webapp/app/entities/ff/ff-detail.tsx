import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './ff.reducer';
import { IFf } from 'app/shared/model/ff.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IFfDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class FfDetail extends React.Component<IFfDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { ffEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Ff [<b>{ffEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="urrW">Urr W</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.urrW} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="nsjjklaGVGL">Nsjjkla GVGL</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.nsjjklaGVGL} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="gffxRHSBKMA">Gffx RHSBKMA</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.gffxRHSBKMA} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="myqaeM">Myqae M</span>
            </dt>
            <dd>{ffEntity.myqaeM}</dd>
            <dt>
              <span id="aovBRJ">Aov BRJ</span>
            </dt>
            <dd>{ffEntity.aovBRJ}</dd>
            <dt>
              <span id="mvcoQB">Mvco QB</span>
            </dt>
            <dd>{ffEntity.mvcoQB}</dd>
            <dt>
              <span id="xcwhaeeZ">Xcwhaee Z</span>
            </dt>
            <dd>{ffEntity.xcwhaeeZ}</dd>
            <dt>
              <span id="jzrnmeTZSRO">Jzrnme TZSRO</span>
            </dt>
            <dd>{ffEntity.jzrnmeTZSRO}</dd>
            <dt>
              <span id="wiBOYCMCRT">Wi BOYCMCRT</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.wiBOYCMCRT} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="jdrBMJZYTEWE">Jdr BMJZYTEWE</span>
            </dt>
            <dd>{ffEntity.jdrBMJZYTEWE}</dd>
            <dt>
              <span id="gmhZYXPBZ">Gmh ZYXPBZ</span>
            </dt>
            <dd>{ffEntity.gmhZYXPBZ}</dd>
            <dt>
              <span id="iGIGVIBXJR">I GIGVIBXJR</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.iGIGVIBXJR} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="fmfiCDTFJLB">Fmfi CDTFJLB</span>
            </dt>
            <dd>{ffEntity.fmfiCDTFJLB}</dd>
            <dt>
              <span id="ylufADJ">Yluf ADJ</span>
            </dt>
            <dd>{ffEntity.ylufADJ}</dd>
            <dt>
              <span id="pgnatCD">Pgnat CD</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.pgnatCD} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="icwyavUN">Icwyav UN</span>
            </dt>
            <dd>
              <TextFormat value={ffEntity.icwyavUN} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="mfjkCWSH">Mfjk CWSH</span>
            </dt>
            <dd>{ffEntity.mfjkCWSH}</dd>
            <dt>
              <span id="wdufNKFKF">Wduf NKFKF</span>
            </dt>
            <dd>{ffEntity.wdufNKFKF}</dd>
            <dt>
              <span id="tyuboofZLWKPX">Tyuboof ZLWKPX</span>
            </dt>
            <dd>{ffEntity.tyuboofZLWKPX ? 'true' : 'false'}</dd>
            <dt>
              <span id="bCGBSOAH">B CGBSOAH</span>
            </dt>
            <dd>{ffEntity.bCGBSOAH}</dd>
          </dl>
          <Button tag={Link} to="/entity/ff" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/ff/${ffEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ ff }: IRootState) => ({
  ffEntity: ff.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(FfDetail);
