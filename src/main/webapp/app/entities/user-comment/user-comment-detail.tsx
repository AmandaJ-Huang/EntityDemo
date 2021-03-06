import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './user-comment.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const UserCommentDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const userCommentEntity = useAppSelector(state => state.userComment.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="userCommentDetailsHeading">
          <Translate contentKey="entityDemoApp.userComment.detail.title">UserComment</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{userCommentEntity.id}</dd>
          <dt>
            <span id="commentBody">
              <Translate contentKey="entityDemoApp.userComment.commentBody">Comment Body</Translate>
            </span>
          </dt>
          <dd>{userCommentEntity.commentBody}</dd>
          <dt>
            <span id="commentDate">
              <Translate contentKey="entityDemoApp.userComment.commentDate">Comment Date</Translate>
            </span>
          </dt>
          <dd>
            {userCommentEntity.commentDate ? (
              <TextFormat value={userCommentEntity.commentDate} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <Translate contentKey="entityDemoApp.userComment.appUser">App User</Translate>
          </dt>
          <dd>{userCommentEntity.appUser ? userCommentEntity.appUser.id : ''}</dd>
          <dt>
            <Translate contentKey="entityDemoApp.userComment.video">Video</Translate>
          </dt>
          <dd>{userCommentEntity.video ? userCommentEntity.video.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/user-comment" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/user-comment/${userCommentEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default UserCommentDetail;
