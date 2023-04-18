import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IJob } from 'app/shared/model/job.model';
import { Rol } from 'app/shared/model/enumerations/rol.model';
import { Handling } from 'app/shared/model/enumerations/handling.model';
import { getEntity, updateEntity, createEntity, reset } from './job.reducer';

export const JobUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const jobEntity = useAppSelector(state => state.job.entity);
  const loading = useAppSelector(state => state.job.loading);
  const updating = useAppSelector(state => state.job.updating);
  const updateSuccess = useAppSelector(state => state.job.updateSuccess);
  const rolValues = Object.keys(Rol);
  const handlingValues = Object.keys(Handling);

  const handleClose = () => {
    navigate('/job' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...jobEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          rol: 'OPERATIONAL',
          handling: 'RAMP',
          ...jobEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="rhv3App.job.home.createOrEditLabel" data-cy="JobCreateUpdateHeading">
            Create or edit a Job
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? <ValidatedField name="id" required readOnly id="job-id" label="ID" validate={{ required: true }} /> : null}
              <ValidatedField
                label="Job Title"
                id="job-jobTitle"
                name="jobTitle"
                data-cy="jobTitle"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                  maxLength: { value: 100, message: 'This field cannot be longer than 100 characters.' },
                }}
              />
              <ValidatedField label="Rol" id="job-rol" name="rol" data-cy="rol" type="select">
                {rolValues.map(rol => (
                  <option value={rol} key={rol}>
                    {rol}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField label="Handling" id="job-handling" name="handling" data-cy="handling" type="select">
                {handlingValues.map(handling => (
                  <option value={handling} key={handling}>
                    {handling}
                  </option>
                ))}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/job" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">Back</span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp; Save
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default JobUpdate;
