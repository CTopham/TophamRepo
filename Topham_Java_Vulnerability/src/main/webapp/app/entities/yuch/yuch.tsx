import React from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './yuch.reducer';
import { IYuch } from 'app/shared/model/yuch.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IYuchProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IYuchState = IPaginationBaseState;

export class Yuch extends React.Component<IYuchProps, IYuchState> {
  state: IYuchState = {
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
    const { yuchList, match } = this.props;
    return (
      <div>
        <h2 id="yuch-heading">
          Yuches
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Yuch
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
            {yuchList && yuchList.length > 0 ? (
              <Table responsive>
                <thead>
                  <tr>
                    <th className="hand" onClick={this.sort('id')}>
                      ID <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('qpswwvISLUJ')}>
                      Qpswwv ISLUJ <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('bjvdtahYZTHGS')}>
                      Bjvdtah YZTHGS <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('xGUNU')}>
                      X GUNU <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('eS')}>
                      E S <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('sfSY')}>
                      Sf SY <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('kmrfRTQTZD')}>
                      Kmrf RTQTZD <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('ebdPPFKSZN')}>
                      Ebd PPFKSZN <FontAwesomeIcon icon="sort" />
                    </th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  {yuchList.map((yuch, i) => (
                    <tr key={`entity-${i}`}>
                      <td>
                        <Button tag={Link} to={`${match.url}/${yuch.id}`} color="link" size="sm">
                          {yuch.id}
                        </Button>
                      </td>
                      <td>{yuch.qpswwvISLUJ}</td>
                      <td>
                        <TextFormat type="date" value={yuch.bjvdtahYZTHGS} format={APP_DATE_FORMAT} />
                      </td>
                      <td>{yuch.xGUNU}</td>
                      <td>{yuch.eS}</td>
                      <td>{yuch.sfSY}</td>
                      <td>{yuch.kmrfRTQTZD}</td>
                      <td>
                        <TextFormat type="date" value={yuch.ebdPPFKSZN} format={APP_DATE_FORMAT} />
                      </td>
                      <td className="text-right">
                        <div className="btn-group flex-btn-group-container">
                          <Button tag={Link} to={`${match.url}/${yuch.id}`} color="info" size="sm">
                            <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${yuch.id}/edit`} color="primary" size="sm">
                            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${yuch.id}/delete`} color="danger" size="sm">
                            <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                          </Button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            ) : (
              <div className="alert alert-warning">No Yuches found</div>
            )}
          </InfiniteScroll>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ yuch }: IRootState) => ({
  yuchList: yuch.entities,
  totalItems: yuch.totalItems,
  links: yuch.links,
  entity: yuch.entity,
  updateSuccess: yuch.updateSuccess
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
)(Yuch);
