import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './ynli.reducer';
import { IYnli } from 'app/shared/model/ynli.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IYnliDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class YnliDetail extends React.Component<IYnliDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { ynliEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Ynli [<b>{ynliEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="yzajrxIAYDPK">Yzajrx IAYDPK</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.yzajrxIAYDPK} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="fgvstxxhkBMQOIS">Fgvstxxhk BMQOIS</span>
            </dt>
            <dd>{ynliEntity.fgvstxxhkBMQOIS}</dd>
            <dt>
              <span id="yhbmpkbhBYCNY">Yhbmpkbh BYCNY</span>
            </dt>
            <dd>{ynliEntity.yhbmpkbhBYCNY}</dd>
            <dt>
              <span id="mngKJLIM">Mng KJLIM</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.mngKJLIM} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="qbafFJWJZSBT">Qbaf FJWJZSBT</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.qbafFJWJZSBT} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="bxoqkppJHLG">Bxoqkpp JHLG</span>
            </dt>
            <dd>{ynliEntity.bxoqkppJHLG}</dd>
            <dt>
              <span id="smN">Sm N</span>
            </dt>
            <dd>{ynliEntity.smN}</dd>
            <dt>
              <span id="mrpzrywoEQQJOCFN">Mrpzrywo EQQJOCFN</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.mrpzrywoEQQJOCFN} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="anPRUY">An PRUY</span>
            </dt>
            <dd>{ynliEntity.anPRUY ? 'true' : 'false'}</dd>
            <dt>
              <span id="rmwupkgmxEJPUWYXCD">Rmwupkgmx EJPUWYXCD</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.rmwupkgmxEJPUWYXCD} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="qsnxsihtZPGGTPL">Qsnxsiht ZPGGTPL</span>
            </dt>
            <dd>{ynliEntity.qsnxsihtZPGGTPL}</dd>
            <dt>
              <span id="fayZWWF">Fay ZWWF</span>
            </dt>
            <dd>{ynliEntity.fayZWWF}</dd>
            <dt>
              <span id="oIUPEEOQW">O IUPEEOQW</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.oIUPEEOQW} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="exicFFTTM">Exic FFTTM</span>
            </dt>
            <dd>{ynliEntity.exicFFTTM}</dd>
            <dt>
              <span id="hrluhfDTNWH">Hrluhf DTNWH</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.hrluhfDTNWH} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="erwTLH">Erw TLH</span>
            </dt>
            <dd>
              <TextFormat value={ynliEntity.erwTLH} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
          </dl>
          <Button tag={Link} to="/entity/ynli" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/ynli/${ynliEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ ynli }: IRootState) => ({
  ynliEntity: ynli.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(YnliDetail);
