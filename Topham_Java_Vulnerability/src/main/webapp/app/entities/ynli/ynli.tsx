import React from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './ynli.reducer';
import { IYnli } from 'app/shared/model/ynli.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IYnliProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IYnliState = IPaginationBaseState;

export class Ynli extends React.Component<IYnliProps, IYnliState> {
  state: IYnliState = {
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
    const { ynliList, match } = this.props;
    return (
      <div>
        <h2 id="ynli-heading">
          Ynlis
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Ynli
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
            {ynliList && ynliList.length > 0 ? (
              <Table responsive>
                <thead>
                  <tr>
                    <th className="hand" onClick={this.sort('id')}>
                      ID <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('yzajrxIAYDPK')}>
                      Yzajrx IAYDPK <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('fgvstxxhkBMQOIS')}>
                      Fgvstxxhk BMQOIS <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('yhbmpkbhBYCNY')}>
                      Yhbmpkbh BYCNY <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('mngKJLIM')}>
                      Mng KJLIM <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('qbafFJWJZSBT')}>
                      Qbaf FJWJZSBT <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('bxoqkppJHLG')}>
                      Bxoqkpp JHLG <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('smN')}>
                      Sm N <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('mrpzrywoEQQJOCFN')}>
                      Mrpzrywo EQQJOCFN <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('anPRUY')}>
                      An PRUY <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('rmwupkgmxEJPUWYXCD')}>
                      Rmwupkgmx EJPUWYXCD <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('qsnxsihtZPGGTPL')}>
                      Qsnxsiht ZPGGTPL <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('fayZWWF')}>
                      Fay ZWWF <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('oIUPEEOQW')}>
                      O IUPEEOQW <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('exicFFTTM')}>
                      Exic FFTTM <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('hrluhfDTNWH')}>
                      Hrluhf DTNWH <FontAwesomeIcon icon="sort" />
                    </th>
                    <th className="hand" onClick={this.sort('erwTLH')}>
                      Erw TLH <FontAwesomeIcon icon="sort" />
                    </th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  {ynliList.map((ynli, i) => (
                    <tr key={`entity-${i}`}>
                      <td>
                        <Button tag={Link} to={`${match.url}/${ynli.id}`} color="link" size="sm">
                          {ynli.id}
                        </Button>
                      </td>
                      <td>
                        <TextFormat type="date" value={ynli.yzajrxIAYDPK} format={APP_DATE_FORMAT} />
                      </td>
                      <td>{ynli.fgvstxxhkBMQOIS}</td>
                      <td>{ynli.yhbmpkbhBYCNY}</td>
                      <td>
                        <TextFormat type="date" value={ynli.mngKJLIM} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>
                        <TextFormat type="date" value={ynli.qbafFJWJZSBT} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>{ynli.bxoqkppJHLG}</td>
                      <td>{ynli.smN}</td>
                      <td>
                        <TextFormat type="date" value={ynli.mrpzrywoEQQJOCFN} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>{ynli.anPRUY ? 'true' : 'false'}</td>
                      <td>
                        <TextFormat type="date" value={ynli.rmwupkgmxEJPUWYXCD} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td>{ynli.qsnxsihtZPGGTPL}</td>
                      <td>{ynli.fayZWWF}</td>
                      <td>
                        <TextFormat type="date" value={ynli.oIUPEEOQW} format={APP_DATE_FORMAT} />
                      </td>
                      <td>{ynli.exicFFTTM}</td>
                      <td>
                        <TextFormat type="date" value={ynli.hrluhfDTNWH} format={APP_DATE_FORMAT} />
                      </td>
                      <td>
                        <TextFormat type="date" value={ynli.erwTLH} format={APP_LOCAL_DATE_FORMAT} />
                      </td>
                      <td className="text-right">
                        <div className="btn-group flex-btn-group-container">
                          <Button tag={Link} to={`${match.url}/${ynli.id}`} color="info" size="sm">
                            <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${ynli.id}/edit`} color="primary" size="sm">
                            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                          </Button>
                          <Button tag={Link} to={`${match.url}/${ynli.id}/delete`} color="danger" size="sm">
                            <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                          </Button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            ) : (
              <div className="alert alert-warning">No Ynlis found</div>
            )}
          </InfiniteScroll>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ ynli }: IRootState) => ({
  ynliList: ynli.entities,
  totalItems: ynli.totalItems,
  links: ynli.links,
  entity: ynli.entity,
  updateSuccess: ynli.updateSuccess
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
)(Ynli);
