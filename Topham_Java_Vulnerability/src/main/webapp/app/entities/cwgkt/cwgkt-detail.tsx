import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './cwgkt.reducer';
import { ICwgkt } from 'app/shared/model/cwgkt.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICwgktDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class CwgktDetail extends React.Component<ICwgktDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { cwgktEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Cwgkt [<b>{cwgktEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="datqyrdSSUVSL">Datqyrd SSUVSL</span>
            </dt>
            <dd>{cwgktEntity.datqyrdSSUVSL}</dd>
            <dt>
              <span id="xiuoesWMTO">Xiuoes WMTO</span>
            </dt>
            <dd>{cwgktEntity.xiuoesWMTO}</dd>
            <dt>
              <span id="wjmkgOKZEHAMR">Wjmkg OKZEHAMR</span>
            </dt>
            <dd>
              <TextFormat value={cwgktEntity.wjmkgOKZEHAMR} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="iwppbN">Iwppb N</span>
            </dt>
            <dd>{cwgktEntity.iwppbN}</dd>
            <dt>
              <span id="uwzPKAL">Uwz PKAL</span>
            </dt>
            <dd>
              <TextFormat value={cwgktEntity.uwzPKAL} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="gjdZ">Gjd Z</span>
            </dt>
            <dd>{cwgktEntity.gjdZ ? 'true' : 'false'}</dd>
            <dt>
              <span id="knYEODEX">Kn YEODEX</span>
            </dt>
            <dd>{cwgktEntity.knYEODEX}</dd>
            <dt>
              <span id="hecwxJSYQPCP">Hecwx JSYQPCP</span>
            </dt>
            <dd>
              <TextFormat value={cwgktEntity.hecwxJSYQPCP} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="qiesctruzNQSQQFKXR">Qiesctruz NQSQQFKXR</span>
            </dt>
            <dd>{cwgktEntity.qiesctruzNQSQQFKXR}</dd>
            <dt>
              <span id="ecstKPPENUEL">Ecst KPPENUEL</span>
            </dt>
            <dd>{cwgktEntity.ecstKPPENUEL}</dd>
            <dt>
              <span id="rygwcTQG">Rygwc TQG</span>
            </dt>
            <dd>{cwgktEntity.rygwcTQG}</dd>
            <dt>
              <span id="zusrW">Zusr W</span>
            </dt>
            <dd>{cwgktEntity.zusrW ? 'true' : 'false'}</dd>
            <dt>
              <span id="xmidVONEL">Xmid VONEL</span>
            </dt>
            <dd>{cwgktEntity.xmidVONEL}</dd>
            <dt>
              <span id="msolwyOWV">Msolwy OWV</span>
            </dt>
            <dd>{cwgktEntity.msolwyOWV}</dd>
            <dt>
              <span id="oyepoAOIUC">Oyepo AOIUC</span>
            </dt>
            <dd>{cwgktEntity.oyepoAOIUC}</dd>
            <dt>
              <span id="whmhgtjcfGVTDZE">Whmhgtjcf GVTDZE</span>
            </dt>
            <dd>
              <TextFormat value={cwgktEntity.whmhgtjcfGVTDZE} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="immakFG">Immak FG</span>
            </dt>
            <dd>{cwgktEntity.immakFG}</dd>
            <dt>
              <span id="jbagfJNAN">Jbagf JNAN</span>
            </dt>
            <dd>{cwgktEntity.jbagfJNAN}</dd>
          </dl>
          <Button tag={Link} to="/entity/cwgkt" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/cwgkt/${cwgktEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ cwgkt }: IRootState) => ({
  cwgktEntity: cwgkt.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CwgktDetail);
