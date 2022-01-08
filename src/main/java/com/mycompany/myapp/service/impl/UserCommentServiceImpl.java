package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.UserComment;
import com.mycompany.myapp.repository.UserCommentRepository;
import com.mycompany.myapp.service.UserCommentService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserComment}.
 */
@Service
@Transactional
public class UserCommentServiceImpl implements UserCommentService {

    private final Logger log = LoggerFactory.getLogger(UserCommentServiceImpl.class);

    private final UserCommentRepository userCommentRepository;

    public UserCommentServiceImpl(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    @Override
    public UserComment save(UserComment userComment) {
        log.debug("Request to save UserComment : {}", userComment);
        return userCommentRepository.save(userComment);
    }

    @Override
    public Optional<UserComment> partialUpdate(UserComment userComment) {
        log.debug("Request to partially update UserComment : {}", userComment);

        return userCommentRepository
            .findById(userComment.getId())
            .map(existingUserComment -> {
                if (userComment.getCommentBody() != null) {
                    existingUserComment.setCommentBody(userComment.getCommentBody());
                }
                if (userComment.getCommentDate() != null) {
                    existingUserComment.setCommentDate(userComment.getCommentDate());
                }

                return existingUserComment;
            })
            .map(userCommentRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserComment> findAll() {
        log.debug("Request to get all UserComments");
        return userCommentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserComment> findOne(Long id) {
        log.debug("Request to get UserComment : {}", id);
        return userCommentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserComment : {}", id);
        userCommentRepository.deleteById(id);
    }
}
