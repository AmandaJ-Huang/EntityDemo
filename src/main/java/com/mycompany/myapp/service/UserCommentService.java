package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.UserComment;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UserComment}.
 */
public interface UserCommentService {
    /**
     * Save a userComment.
     *
     * @param userComment the entity to save.
     * @return the persisted entity.
     */
    UserComment save(UserComment userComment);

    /**
     * Partially updates a userComment.
     *
     * @param userComment the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserComment> partialUpdate(UserComment userComment);

    /**
     * Get all the userComments.
     *
     * @return the list of entities.
     */
    List<UserComment> findAll();

    /**
     * Get the "id" userComment.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserComment> findOne(Long id);

    /**
     * Delete the "id" userComment.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
