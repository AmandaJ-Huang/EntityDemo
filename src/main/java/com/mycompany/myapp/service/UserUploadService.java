package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.UserUpload;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UserUpload}.
 */
public interface UserUploadService {
    /**
     * Save a userUpload.
     *
     * @param userUpload the entity to save.
     * @return the persisted entity.
     */
    UserUpload save(UserUpload userUpload);

    /**
     * Partially updates a userUpload.
     *
     * @param userUpload the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserUpload> partialUpdate(UserUpload userUpload);

    /**
     * Get all the userUploads.
     *
     * @return the list of entities.
     */
    List<UserUpload> findAll();

    /**
     * Get the "id" userUpload.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserUpload> findOne(Long id);

    /**
     * Delete the "id" userUpload.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
