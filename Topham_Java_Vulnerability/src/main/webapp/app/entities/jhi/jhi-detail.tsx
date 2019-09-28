import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './jhi.reducer';
import { IJhi } from 'app/shared/model/jhi.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IJhiDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class JhiDetail extends React.Component<IJhiDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { jhiEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            Jhi [<b>{jhiEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="kuxgvrghgZWUVBAS">Kuxgvrghg ZWUVBAS</span>
            </dt>
            <dd>{jhiEntity.kuxgvrghgZWUVBAS}</dd>
            <dt>
              <span id="cyoluqjxCCMPZM">Cyoluqjx CCMPZM</span>
            </dt>
            <dd>{jhiEntity.cyoluqjxCCMPZM}</dd>
            <dt>
              <span id="cGHPVLNPHG">C GHPVLNPHG</span>
            </dt>
            <dd>{jhiEntity.cGHPVLNPHG ? 'true' : 'false'}</dd>
            <dt>
              <span id="fnsunJGEXY">Fnsun JGEXY</span>
            </dt>
            <dd>{jhiEntity.fnsunJGEXY}</dd>
            <dt>
              <span id="xfhMRAWOAD">Xfh MRAWOAD</span>
            </dt>
            <dd>{jhiEntity.xfhMRAWOAD}</dd>
            <dt>
              <span id="rhcuagusEM">Rhcuagus EM</span>
            </dt>
            <dd>{jhiEntity.rhcuagusEM}</dd>
            <dt>
              <span id="nnmuicgOII">Nnmuicg OII</span>
            </dt>
            <dd>{jhiEntity.nnmuicgOII}</dd>
            <dt>
              <span id="cqCGPSOPJC">Cq CGPSOPJC</span>
            </dt>
            <dd>{jhiEntity.cqCGPSOPJC}</dd>
            <dt>
              <span id="ycWFMXX">Yc WFMXX</span>
            </dt>
            <dd>{jhiEntity.ycWFMXX ? 'true' : 'false'}</dd>
            <dt>
              <span id="vIEFKCLJCN">V IEFKCLJCN</span>
            </dt>
            <dd>{jhiEntity.vIEFKCLJCN ? 'true' : 'false'}</dd>
            <dt>
              <span id="ulorfvrzNGZQT">Ulorfvrz NGZQT</span>
            </dt>
            <dd>
              <TextFormat value={jhiEntity.ulorfvrzNGZQT} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="sfbrwwuezNWHCMT">Sfbrwwuez NWHCMT</span>
            </dt>
            <dd>{jhiEntity.sfbrwwuezNWHCMT}</dd>
            <dt>
              <span id="ysmxlujouDKMEIUUG">Ysmxlujou DKMEIUUG</span>
            </dt>
            <dd>{jhiEntity.ysmxlujouDKMEIUUG}</dd>
            <dt>
              <span id="bebpxFFA">Bebpx FFA</span>
            </dt>
            <dd>
              <TextFormat value={jhiEntity.bebpxFFA} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="fjiePMF">Fjie PMF</span>
            </dt>
            <dd>{jhiEntity.fjiePMF}</dd>
          </dl>
          <Button tag={Link} to="/entity/jhi" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/jhi/${jhiEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ jhi }: IRootState) => ({
  jhiEntity: jhi.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JhiDetail);
