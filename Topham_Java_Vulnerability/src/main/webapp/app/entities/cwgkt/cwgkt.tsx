import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './cwgkt.reducer';
import { ICwgkt } from 'app/shared/model/cwgkt.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface ICwgktProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type ICwgktState = IPaginationBaseState;

export class Cwgkt extends React.Component<ICwgktProps, ICwgktState> {
  state: ICwgktState = {
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
    const { cwgktList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="cwgkt-heading">
          Cwgkts
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Cwgkt
          </Link>
        </h2>
        <div className="table-responsive">
          {cwgktList && cwgktList.length > 0 ? (
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={this.sort('id')}>
                    ID <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('datqyrdSSUVSL')}>
                    Datqyrd SSUVSL <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xiuoesWMTO')}>
                    Xiuoes WMTO <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('wjmkgOKZEHAMR')}>
                    Wjmkg OKZEHAMR <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('iwppbN')}>
                    Iwppb N <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('uwzPKAL')}>
                    Uwz PKAL <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('gjdZ')}>
                    Gjd Z <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('knYEODEX')}>
                    Kn YEODEX <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('hecwxJSYQPCP')}>
                    Hecwx JSYQPCP <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('qiesctruzNQSQQFKXR')}>
                    Qiesctruz NQSQQFKXR <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ecstKPPENUEL')}>
                    Ecst KPPENUEL <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('rygwcTQG')}>
                    Rygwc TQG <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('zusrW')}>
                    Zusr W <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xmidVONEL')}>
                    Xmid VONEL <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('msolwyOWV')}>
                    Msolwy OWV <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('oyepoAOIUC')}>
                    Oyepo AOIUC <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('whmhgtjcfGVTDZE')}>
                    Whmhgtjcf GVTDZE <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('immakFG')}>
                    Immak FG <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('jbagfJNAN')}>
                    Jbagf JNAN <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {cwgktList.map((cwgkt, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${cwgkt.id}`} color="link" size="sm">
                        {cwgkt.id}
                      </Button>
                    </td>
                    <td>{cwgkt.datqyrdSSUVSL}</td>
                    <td>{cwgkt.xiuoesWMTO}</td>
                    <td>
                      <TextFormat type="date" value={cwgkt.wjmkgOKZEHAMR} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{cwgkt.iwppbN}</td>
                    <td>
                      <TextFormat type="date" value={cwgkt.uwzPKAL} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{cwgkt.gjdZ ? 'true' : 'false'}</td>
                    <td>{cwgkt.knYEODEX}</td>
                    <td>
                      <TextFormat type="date" value={cwgkt.hecwxJSYQPCP} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{cwgkt.qiesctruzNQSQQFKXR}</td>
                    <td>{cwgkt.ecstKPPENUEL}</td>
                    <td>{cwgkt.rygwcTQG}</td>
                    <td>{cwgkt.zusrW ? 'true' : 'false'}</td>
                    <td>{cwgkt.xmidVONEL}</td>
                    <td>{cwgkt.msolwyOWV}</td>
                    <td>{cwgkt.oyepoAOIUC}</td>
                    <td>
                      <TextFormat type="date" value={cwgkt.whmhgtjcfGVTDZE} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{cwgkt.immakFG}</td>
                    <td>{cwgkt.jbagfJNAN}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${cwgkt.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${cwgkt.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${cwgkt.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">No Cwgkts found</div>
          )}
        </div>
        <div className={cwgktList && cwgktList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ cwgkt }: IRootState) => ({
  cwgktList: cwgkt.entities,
  totalItems: cwgkt.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Cwgkt);
