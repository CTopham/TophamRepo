import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './jhi.reducer';
import { IJhi } from 'app/shared/model/jhi.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IJhiProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IJhiState = IPaginationBaseState;

export class Jhi extends React.Component<IJhiProps, IJhiState> {
  state: IJhiState = {
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
    const { jhiList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="jhi-heading">
          Jhis
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Jhi
          </Link>
        </h2>
        <div className="table-responsive">
          {jhiList && jhiList.length > 0 ? (
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={this.sort('id')}>
                    ID <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('kuxgvrghgZWUVBAS')}>
                    Kuxgvrghg ZWUVBAS <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cyoluqjxCCMPZM')}>
                    Cyoluqjx CCMPZM <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cGHPVLNPHG')}>
                    C GHPVLNPHG <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('fnsunJGEXY')}>
                    Fnsun JGEXY <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xfhMRAWOAD')}>
                    Xfh MRAWOAD <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('rhcuagusEM')}>
                    Rhcuagus EM <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('nnmuicgOII')}>
                    Nnmuicg OII <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cqCGPSOPJC')}>
                    Cq CGPSOPJC <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ycWFMXX')}>
                    Yc WFMXX <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('vIEFKCLJCN')}>
                    V IEFKCLJCN <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ulorfvrzNGZQT')}>
                    Ulorfvrz NGZQT <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('sfbrwwuezNWHCMT')}>
                    Sfbrwwuez NWHCMT <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ysmxlujouDKMEIUUG')}>
                    Ysmxlujou DKMEIUUG <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('bebpxFFA')}>
                    Bebpx FFA <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('fjiePMF')}>
                    Fjie PMF <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {jhiList.map((jhi, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${jhi.id}`} color="link" size="sm">
                        {jhi.id}
                      </Button>
                    </td>
                    <td>{jhi.kuxgvrghgZWUVBAS}</td>
                    <td>{jhi.cyoluqjxCCMPZM}</td>
                    <td>{jhi.cGHPVLNPHG ? 'true' : 'false'}</td>
                    <td>{jhi.fnsunJGEXY}</td>
                    <td>{jhi.xfhMRAWOAD}</td>
                    <td>{jhi.rhcuagusEM}</td>
                    <td>{jhi.nnmuicgOII}</td>
                    <td>{jhi.cqCGPSOPJC}</td>
                    <td>{jhi.ycWFMXX ? 'true' : 'false'}</td>
                    <td>{jhi.vIEFKCLJCN ? 'true' : 'false'}</td>
                    <td>
                      <TextFormat type="date" value={jhi.ulorfvrzNGZQT} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{jhi.sfbrwwuezNWHCMT}</td>
                    <td>{jhi.ysmxlujouDKMEIUUG}</td>
                    <td>
                      <TextFormat type="date" value={jhi.bebpxFFA} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{jhi.fjiePMF}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${jhi.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${jhi.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${jhi.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">No Jhis found</div>
          )}
        </div>
        <div className={jhiList && jhiList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ jhi }: IRootState) => ({
  jhiList: jhi.entities,
  totalItems: jhi.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Jhi);
