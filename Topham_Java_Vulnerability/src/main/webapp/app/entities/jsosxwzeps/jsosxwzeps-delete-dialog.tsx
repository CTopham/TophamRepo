import React from 'react';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router-dom';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';
import { ICrudGetAction, ICrudDeleteAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IJsosxwzeps } from 'app/shared/model/jsosxwzeps.model';
import { IRootState } from 'app/shared/reducers';
import { getEntity, deleteEntity } from './jsosxwzeps.reducer';

export interface IJsosxwzepsDeleteDialogProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class JsosxwzepsDeleteDialog extends React.Component<IJsosxwzepsDeleteDialogProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  confirmDelete = event => {
    this.props.deleteEntity(this.props.jsosxwzepsEntity.id);
    this.handleClose(event);
  };

  handleClose = event => {
    event.stopPropagation();
    this.props.history.goBack();
  };

  render() {
    const { jsosxwzepsEntity } = this.props;
    return (
      <Modal isOpen toggle={this.handleClose}>
        <ModalHeader toggle={this.handleClose}>Confirm delete operation</ModalHeader>
        <ModalBody id="zjqabApp.jsosxwzeps.delete.question">Are you sure you want to delete this Jsosxwzeps?</ModalBody>
        <ModalFooter>
          <Button color="secondary" onClick={this.handleClose}>
            <FontAwesomeIcon icon="ban" />
            &nbsp; Cancel
          </Button>
          <Button id="ofoqm-confirm-delete-jsosxwzeps" color="danger" onClick={this.confirmDelete}>
            <FontAwesomeIcon icon="trash" />
            &nbsp; Delete
          </Button>
        </ModalFooter>
      </Modal>
    );
  }
}

const mapStateToProps = ({ jsosxwzeps }: IRootState) => ({
  jsosxwzepsEntity: jsosxwzeps.entity
});

const mapDispatchToProps = { getEntity, deleteEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(JsosxwzepsDeleteDialog);
