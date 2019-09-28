import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './rletex.reducer';
import { IRletex } from 'app/shared/model/rletex.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IRletexProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IRletexState = IPaginationBaseState;

export class Rletex extends React.Component<IRletexProps, IRletexState> {
  state: IRletexState = {
    ...getSortState(this.props.location, ITEMS_PER_PAGE)
  };

  componentDidMount() {
    this.getEntities();
  }

  sort = prop => () => {
    this.setState(
      {
        order: this.state.order === 'asc' ? 'desc' : 'asc',
        sort: prop
      },
      () => this.sortEntities()
    );
  };

  sortEntities() {
    this.getEntities();
    this.props.history.push(`${this.props.location.pathname}?page=${this.state.activePage}&sort=${this.state.sort},${this.state.order}`);
  }

  handlePagination = activePage => this.setState({ activePage }, () => this.sortEntities());

  getEntities = () => {
    const { activePage, itemsPerPage, sort, order } = this.state;
    this.props.getEntities(activePage - 1, itemsPerPage, `${sort},${order}`);
  };

  render() {
    const { rletexList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="rletex-heading">
          Rletexes
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Rletex
          </Link>
        </h2>
        <div className="table-responsive">
          {rletexList && rletexList.length > 0 ? (
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={this.sort('id')}>
                    ID <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('sroeihTIMOVOQHQ')}>
                    Sroeih TIMOVOQHQ <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('lczcjlHYBZK')}>
                    Lczcjl HYBZK <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xlkJZDTGUDMI')}>
                    Xlk JZDTGUDMI <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dhzewmhhMB')}>
                    Dhzewmhh MB <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('clturNT')}>
                    Cltur NT <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('kwblADTZ')}>
                    Kwbl ADTZ <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('mqnwbGJX')}>
                    Mqnwb GJX <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xOZIR')}>
                    X OZIR <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('vmqV')}>
                    Vmq V <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('iGGLNXLDXS')}>
                    I GGLNXLDXS <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('vksnruhcGXVIWCT')}>
                    Vksnruhc GXVIWCT <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('munxnaY')}>
                    Munxna Y <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('qihfHXRY')}>
                    Qihf HXRY <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dwfucglgXND')}>
                    Dwfucglg XND <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('yoUNHREZTLG')}>
                    Yo UNHREZTLG <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('sytdER')}>
                    Sytd ER <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('zNBBBICYP')}>
                    Z NBBBICYP <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ifotjfAWXJDJIF')}>
                    Ifotjf AWXJDJIF <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {rletexList.map((rletex, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${rletex.id}`} color="link" size="sm">
                        {rletex.id}
                      </Button>
                    </td>
                    <td>{rletex.sroeihTIMOVOQHQ ? 'true' : 'false'}</td>
                    <td>{rletex.lczcjlHYBZK}</td>
                    <td>
                      <TextFormat type="date" value={rletex.xlkJZDTGUDMI} format={APP_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={rletex.dhzewmhhMB} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{rletex.clturNT}</td>
                    <td>{rletex.kwblADTZ}</td>
                    <td>{rletex.mqnwbGJX}</td>
                    <td>{rletex.xOZIR ? 'true' : 'false'}</td>
                    <td>{rletex.vmqV}</td>
                    <td>
                      <TextFormat type="date" value={rletex.iGGLNXLDXS} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{rletex.vksnruhcGXVIWCT ? 'true' : 'false'}</td>
                    <td>{rletex.munxnaY}</td>
                    <td>
                      <TextFormat type="date" value={rletex.qihfHXRY} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{rletex.dwfucglgXND}</td>
                    <td>{rletex.yoUNHREZTLG}</td>
                    <td>{rletex.sytdER}</td>
                    <td>{rletex.zNBBBICYP}</td>
                    <td>{rletex.ifotjfAWXJDJIF ? 'true' : 'false'}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${rletex.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${rletex.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${rletex.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">No Rletexes found</div>
          )}
        </div>
        <div className={rletexList && rletexList.length > 0 ? '' : 'd-none'}>
          <Row className="justify-content-center">
            <JhiItemCount page={this.state.activePage} total={totalItems} itemsPerPage={this.state.itemsPerPage} />
          </Row>
          <Row className="justify-content-center">
            <JhiPagination
              activePage={this.state.activePage}
              onSelect={this.handlePagination}
              maxButtons={5}
              itemsPerPage={this.state.itemsPerPage}
              totalItems={this.props.totalItems}
            />
          </Row>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ rletex }: IRootState) => ({
  rletexList: rletex.entities,
  totalItems: rletex.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Rletex);
