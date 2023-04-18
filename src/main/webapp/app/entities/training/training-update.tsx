import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICourse } from 'app/shared/model/course.model';
import { getEntities as getCourses } from 'app/entities/course/course.reducer';
import { IEmployee } from 'app/shared/model/employee.model';
import { getEntities as getEmployees } from 'app/entities/employee/employee.reducer';
import { ITraining } from 'app/shared/model/training.model';
import { getEntity, updateEntity, createEntity, reset } from './training.reducer';

export const TrainingUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const courses = useAppSelector(state => state.course.entities);
  const employees = useAppSelector(state => state.employee.entities);
  const trainingEntity = useAppSelector(state => state.training.entity);
  const loading = useAppSelector(state => state.training.loading);
  const updating = useAppSelector(state => state.training.updating);
  const updateSuccess = useAppSelector(state => state.training.updateSuccess);

  const handleClose = () => {
    navigate('/training' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getCourses({}));
    dispatch(getEmployees({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.date = convertDateTimeToServer(values.date);
    values.expiry = convertDateTimeToServer(values.expiry);

    const entity = {
      ...trainingEntity,
      ...values,
      course: courses.find(it => it.id.toString() === values.course.toString()),
      employee: employees.find(it => it.id.toString() === values.employee.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          date: displayDefaultDateTime(),
          expiry: displayDefaultDateTime(),
        }
      : {
          ...trainingEntity,
          date: convertDateTimeFromServer(trainingEntity.date),
          expiry: convertDateTimeFromServer(trainingEntity.expiry),
          course: trainingEntity?.course?.id,
          employee: trainingEntity?.employee?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="rhv3App.training.home.createOrEditLabel" data-cy="TrainingCreateUpdateHeading">
            Create or edit a Training
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? <ValidatedField name="id" required readOnly id="training-id" label="ID" validate={{ required: true }} /> : null}
              <ValidatedField label="Course Id" id="training-courseId" name="courseId" data-cy="courseId" type="text" />
              <ValidatedField label="Employee Id" id="training-employeeId" name="employeeId" data-cy="employeeId" type="text" />
              <ValidatedField
                label="Code"
                id="training-code"
                name="code"
                data-cy="code"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                  maxLength: { value: 20, message: 'This field cannot be longer than 20 characters.' },
                }}
              />
              <ValidatedField
                label="Date"
                id="training-date"
                name="date"
                data-cy="date"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField
                label="Expiry"
                id="training-expiry"
                name="expiry"
                data-cy="expiry"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField id="training-course" name="course" data-cy="course" label="Course" type="select">
                <option value="" key="0" />
                {courses
                  ? courses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField id="training-employee" name="employee" data-cy="employee" label="Employee" type="select">
                <option value="" key="0" />
                {employees
                  ? employees.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/training" replace color="info">
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

export default TrainingUpdate;
