import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './rletex.reducer';
import { IRletex } from 'app/shared/model/rletex.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IRletexDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class RletexDetail extends React.Component<IRletexDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { rletexEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Rletex [<b>{rletexEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="sroeihTIMOVOQHQ">Sroeih TIMOVOQHQ</span>
            </dt>
            <dd>{rletexEntity.sroeihTIMOVOQHQ ? 'true' : 'false'}</dd>
            <dt>
              <span id="lczcjlHYBZK">Lczcjl HYBZK</span>
            </dt>
            <dd>{rletexEntity.lczcjlHYBZK}</dd>
            <dt>
              <span id="xlkJZDTGUDMI">Xlk JZDTGUDMI</span>
            </dt>
            <dd>
              <TextFormat value={rletexEntity.xlkJZDTGUDMI} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dhzewmhhMB">Dhzewmhh MB</span>
            </dt>
            <dd>
              <TextFormat value={rletexEntity.dhzewmhhMB} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="clturNT">Cltur NT</span>
            </dt>
            <dd>{rletexEntity.clturNT}</dd>
            <dt>
              <span id="kwblADTZ">Kwbl ADTZ</span>
            </dt>
            <dd>{rletexEntity.kwblADTZ}</dd>
            <dt>
              <span id="mqnwbGJX">Mqnwb GJX</span>
            </dt>
            <dd>{rletexEntity.mqnwbGJX}</dd>
            <dt>
              <span id="xOZIR">X OZIR</span>
            </dt>
            <dd>{rletexEntity.xOZIR ? 'true' : 'false'}</dd>
            <dt>
              <span id="vmqV">Vmq V</span>
            </dt>
            <dd>{rletexEntity.vmqV}</dd>
            <dt>
              <span id="iGGLNXLDXS">I GGLNXLDXS</span>
            </dt>
            <dd>
              <TextFormat value={rletexEntity.iGGLNXLDXS} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="vksnruhcGXVIWCT">Vksnruhc GXVIWCT</span>
            </dt>
            <dd>{rletexEntity.vksnruhcGXVIWCT ? 'true' : 'false'}</dd>
            <dt>
              <span id="munxnaY">Munxna Y</span>
            </dt>
            <dd>{rletexEntity.munxnaY}</dd>
            <dt>
              <span id="qihfHXRY">Qihf HXRY</span>
            </dt>
            <dd>
              <TextFormat value={rletexEntity.qihfHXRY} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dwfucglgXND">Dwfucglg XND</span>
            </dt>
            <dd>{rletexEntity.dwfucglgXND}</dd>
            <dt>
              <span id="yoUNHREZTLG">Yo UNHREZTLG</span>
            </dt>
            <dd>{rletexEntity.yoUNHREZTLG}</dd>
            <dt>
              <span id="sytdER">Sytd ER</span>
            </dt>
            <dd>{rletexEntity.sytdER}</dd>
            <dt>
              <span id="zNBBBICYP">Z NBBBICYP</span>
            </dt>
            <dd>{rletexEntity.zNBBBICYP}</dd>
            <dt>
              <span id="ifotjfAWXJDJIF">Ifotjf AWXJDJIF</span>
            </dt>
            <dd>{rletexEntity.ifotjfAWXJDJIF ? 'true' : 'false'}</dd>
          </dl>
          <Button tag={Link} to="/entity/rletex" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/rletex/${rletexEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ rletex }: IRootState) => ({
  rletexEntity: rletex.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(RletexDetail);
