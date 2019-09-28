import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './sycdotfbx.reducer';
import { ISycdotfbx } from 'app/shared/model/sycdotfbx.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISycdotfbxDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class SycdotfbxDetail extends React.Component<ISycdotfbxDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { sycdotfbxEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Sycdotfbx [<b>{sycdotfbxEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="uoerqrWHAVSPOY">Uoerqr WHAVSPOY</span>
            </dt>
            <dd>{sycdotfbxEntity.uoerqrWHAVSPOY}</dd>
            <dt>
              <span id="vtoeablliMPK">Vtoeablli MPK</span>
            </dt>
            <dd>{sycdotfbxEntity.vtoeablliMPK}</dd>
            <dt>
              <span id="gvAUAOKYBWN">Gv AUAOKYBWN</span>
            </dt>
            <dd>{sycdotfbxEntity.gvAUAOKYBWN}</dd>
            <dt>
              <span id="ylooxrwCAVWCFSFJ">Ylooxrw CAVWCFSFJ</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.ylooxrwCAVWCFSFJ} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="bebohaanSNOHCG">Bebohaan SNOHCG</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.bebohaanSNOHCG} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="phnagMUIFEGY">Phnag MUIFEGY</span>
            </dt>
            <dd>{sycdotfbxEntity.phnagMUIFEGY}</dd>
            <dt>
              <span id="mndiozSZG">Mndioz SZG</span>
            </dt>
            <dd>{sycdotfbxEntity.mndiozSZG ? 'true' : 'false'}</dd>
            <dt>
              <span id="srTDOBHW">Sr TDOBHW</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.srTDOBHW} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="oqhtblwuLMTRLPZMS">Oqhtblwu LMTRLPZMS</span>
            </dt>
            <dd>{sycdotfbxEntity.oqhtblwuLMTRLPZMS}</dd>
            <dt>
              <span id="mDPGGK">M DPGGK</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.mDPGGK} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dgbhxwtLLL">Dgbhxwt LLL</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.dgbhxwtLLL} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="bqguzoagvFCZV">Bqguzoagv FCZV</span>
            </dt>
            <dd>{sycdotfbxEntity.bqguzoagvFCZV}</dd>
            <dt>
              <span id="jqwompJVQH">Jqwomp JVQH</span>
            </dt>
            <dd>{sycdotfbxEntity.jqwompJVQH}</dd>
            <dt>
              <span id="kIMVKQBL">K IMVKQBL</span>
            </dt>
            <dd>{sycdotfbxEntity.kIMVKQBL}</dd>
            <dt>
              <span id="uteAXHLSH">Ute AXHLSH</span>
            </dt>
            <dd>{sycdotfbxEntity.uteAXHLSH}</dd>
            <dt>
              <span id="nntcpjSMOPWFJY">Nntcpj SMOPWFJY</span>
            </dt>
            <dd>{sycdotfbxEntity.nntcpjSMOPWFJY}</dd>
            <dt>
              <span id="vfxsoygABWPMSUQU">Vfxsoyg ABWPMSUQU</span>
            </dt>
            <dd>{sycdotfbxEntity.vfxsoygABWPMSUQU}</dd>
            <dt>
              <span id="fbdigDZKP">Fbdig DZKP</span>
            </dt>
            <dd>
              <TextFormat value={sycdotfbxEntity.fbdigDZKP} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="vigcCOZMN">Vigc COZMN</span>
            </dt>
            <dd>{sycdotfbxEntity.vigcCOZMN}</dd>
          </dl>
          <Button tag={Link} to="/entity/sycdotfbx" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/sycdotfbx/${sycdotfbxEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ sycdotfbx }: IRootState) => ({
  sycdotfbxEntity: sycdotfbx.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SycdotfbxDetail);
