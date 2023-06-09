import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './requirents.reducer';

export const RequirentsDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const requirentsEntity = useAppSelector(state => state.requirents.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="requirentsDetailsHeading">Requirents</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{requirentsEntity.id}</dd>
          <dt>
            <span id="courseId">Course Id</span>
          </dt>
          <dd>{requirentsEntity.courseId}</dd>
          <dt>
            <span id="code">Code</span>
          </dt>
          <dd>{requirentsEntity.code}</dd>
          <dt>
            <span id="expirationInMonth">Expiration In Month</span>
          </dt>
          <dd>{requirentsEntity.expirationInMonth}</dd>
          <dt>
            <span id="kind">Kind</span>
          </dt>
          <dd>{requirentsEntity.kind}</dd>
          <dt>
            <span id="description">Description</span>
          </dt>
          <dd>{requirentsEntity.description}</dd>
          <dt>Course</dt>
          <dd>{requirentsEntity.course ? requirentsEntity.course.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/requirents" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/requirents/${requirentsEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default RequirentsDetail;
