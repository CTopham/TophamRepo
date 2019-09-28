import React from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './cf.reducer';
import { ICf } from 'app/shared/model/cf.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface ICfProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type ICfState = IPaginationBaseState;

export class Cf extends React.Component<ICfProps, ICfState> {
  state: ICfState = {
    ...getSortState(this.props.location, ITEMS_PER_PAGE)
  };

  componentDidMount() {
    this.reset();
  }

  componentDidUpdate() {
    if (this.props.updateSuccess) {
      this.reset();
    }
  }

  reset = () => {
    this.props.reset();
    this.setState({ activePage: 1 }, () => {
      this.getEntities();
    });
  };

  handleLoadMore = () => {
    if (window.pageYOffset > 0) {
      this.setState({ activePage: this.state.activePage + 1 }, () => this.getEntities());
    }
  };

  sort = prop => () => {
    this.setState(
      {
        order: this.state.order === 'asc' ? 'desc' : 'asc',
        sort: prop
      },
      () => {
        this.reset();
      }
    );
  };

  getEntities = () => {
    const { activePage, itemsPerPage, sort, order } = this.state;
    this.props.getEntities(activePage - 1, itemsPerPage, `${sort},${order}`);
  };

  render() {
    const { cfList, match } = this.props;
    return (
      <div>
        <h2 id="cf-heading">
          Cfs
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Cf
          </Link>
        </h2>
        <div className="table-responsive">
          <InfiniteScroll
            pageStart={this.state.activePage}
            loadMore={this.handleLoadMore}
            hasMore={this.state.activePage - 1 < this.props.links.next}
            loader={<div className="loader">Loading ...</div>}
            threshold={0}
            initialLoad={false}
          >
            {cfList && cfList.length > 0 ? (
              <Table responsive>
                <thead>
                  <tr>
                    <th className="hand" onClick={this.sort('id')}>
                      ID <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('dszipjLILHDGEB')}>
                      Dszipj LILHDGEB <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('kxHFGGG')}>
                      Kx HFGGG <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('qjqNJ')}>
                      Qjq NJ <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('uycdkngjyEX')}>
                      Uycdkngjy EX <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('lttzrsukkITST')}>
                      Lttzrsukk ITST <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('cwfYZVEIJKE')}>
                      Cwf YZVEIJKE <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('ywuhpryGC')}>
                      Ywuhpry GC <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('euhuyarMVMESJ')}>
                      Euhuyar MVMESJ <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('zwbRBGEWZQDH')}>
                      Zwb RBGEWZQDH <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('yjfmrsuugHRWGXNH')}>
                      Yjfmrsuug HRWGXNH <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('cyLONPOURB')}>
                      Cy LONPOURB <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('tafphcQPQLPZB')}>
                      Tafphc QPQLPZB <FontAwesomeIcon icon="sort" />
                    </th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  {cfList.map((cf, i) => (
                    <tr key={`entity-${i}`}>
                      <td>
                        <Button tag={Link} to={`${match.url}/${cf.id}`} color="link" size="sm">
                          {cf.id}
                        </Button>
                      </td>
                      <td>{cf.dszipjLILHDGEB}</td>
                      <td>{cf.kxHFGGG}</td>
                      <td>{cf.qjqNJ}</td>
                      <td>{cf.uycdkngjyEX}</td>
                      <td>{cf.lttzrsukkITST}</td>
                      <td>{cf.cwfYZVEIJKE}</td>
                      <td>
                        <TextFormat type="date" value={cf.ywuhpryGC} format={APP_DATE_FORMAT} />
                      </td>
                      <td>
                        <TextFormat type="date" value={cf.euhuyarMVMESJ} format={APP_DATE_FORMAT} />
                      </td>
                      <td>{cf.zwbRBGEWZQDH}</td>
                      <td>
                        <TextFormat type="date" value={cf.yjfmrsuugHRWGXNH} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>
                        <TextFormat type="date" value={cf.cyLONPOURB} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>{cf.tafphcQPQLPZB}</td>
                      <td className="text-right">
                        <div className="btn-group flex-btn-group-container">
                          <Button tag={Link} to={`${match.url}/${cf.id}`} color="info" size="sm">
                            <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${cf.id}/edit`} color="primary" size="sm">
                            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${cf.id}/delete`} color="danger" size="sm">
                            <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                          </Button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            ) : (
              <div className="alert alert-warning">No Cfs found</div>
            )}
          </InfiniteScroll>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ cf }: IRootState) => ({
  cfList: cf.entities,
  totalItems: cf.totalItems,
  links: cf.links,
  entity: cf.entity,
  updateSuccess: cf.updateSuccess
});

const mapDispatchToProps = {
  getEntities,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Cf);
