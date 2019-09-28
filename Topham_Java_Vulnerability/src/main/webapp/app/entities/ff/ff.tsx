import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './ff.reducer';
import { IFf } from 'app/shared/model/ff.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IFfProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IFfState = IPaginationBaseState;

export class Ff extends React.Component<IFfProps, IFfState> {
  state: IFfState = {
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
    const { ffList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="ff-heading">
          Ffs
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Ff
          </Link>
        </h2>
        <div className="table-responsive">
          {ffList && ffList.length > 0 ? (
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={this.sort('id')}>
                    ID <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('urrW')}>
                    Urr W <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('nsjjklaGVGL')}>
                    Nsjjkla GVGL <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('gffxRHSBKMA')}>
                    Gffx RHSBKMA <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('myqaeM')}>
                    Myqae M <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('aovBRJ')}>
                    Aov BRJ <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('mvcoQB')}>
                    Mvco QB <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('xcwhaeeZ')}>
                    Xcwhaee Z <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('jzrnmeTZSRO')}>
                    Jzrnme TZSRO <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('wiBOYCMCRT')}>
                    Wi BOYCMCRT <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('jdrBMJZYTEWE')}>
                    Jdr BMJZYTEWE <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('gmhZYXPBZ')}>
                    Gmh ZYXPBZ <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('iGIGVIBXJR')}>
                    I GIGVIBXJR <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('fmfiCDTFJLB')}>
                    Fmfi CDTFJLB <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ylufADJ')}>
                    Yluf ADJ <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('pgnatCD')}>
                    Pgnat CD <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('icwyavUN')}>
                    Icwyav UN <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('mfjkCWSH')}>
                    Mfjk CWSH <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('wdufNKFKF')}>
                    Wduf NKFKF <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('tyuboofZLWKPX')}>
                    Tyuboof ZLWKPX <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('bCGBSOAH')}>
                    B CGBSOAH <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {ffList.map((ff, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${ff.id}`} color="link" size="sm">
                        {ff.id}
                      </Button>
                    </td>
                    <td>
                      <TextFormat type="date" value={ff.urrW} format={APP_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={ff.nsjjklaGVGL} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={ff.gffxRHSBKMA} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{ff.myqaeM}</td>
                    <td>{ff.aovBRJ}</td>
                    <td>{ff.mvcoQB}</td>
                    <td>{ff.xcwhaeeZ}</td>
                    <td>{ff.jzrnmeTZSRO}</td>
                    <td>
                      <TextFormat type="date" value={ff.wiBOYCMCRT} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{ff.jdrBMJZYTEWE}</td>
                    <td>{ff.gmhZYXPBZ}</td>
                    <td>
                      <TextFormat type="date" value={ff.iGIGVIBXJR} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{ff.fmfiCDTFJLB}</td>
                    <td>{ff.ylufADJ}</td>
                    <td>
                      <TextFormat type="date" value={ff.pgnatCD} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={ff.icwyavUN} format={APP_DATE_FORMAT} />
                    </td>
                    <td>{ff.mfjkCWSH}</td>
                    <td>{ff.wdufNKFKF}</td>
                    <td>{ff.tyuboofZLWKPX ? 'true' : 'false'}</td>
                    <td>{ff.bCGBSOAH}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${ff.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${ff.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${ff.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">No Ffs found</div>
          )}
        </div>
        <div className={ffList && ffList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ ff }: IRootState) => ({
  ffList: ff.entities,
  totalItems: ff.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Ff);
