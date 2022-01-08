package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.UserFavorites;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link UserFavorites}.
 */
public interface UserFavoritesService {
    /**
     * Save a userFavorites.
     *
     * @param userFavorites the entity to save.
     * @return the persisted entity.
     */
    UserFavorites save(UserFavorites userFavorites);

    /**
     * Partially updates a userFavorites.
     *
     * @param userFavorites the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserFavorites> partialUpdate(UserFavorites userFavorites);

    /**
     * Get all the userFavorites.
     *
     * @return the list of entities.
     */
    List<UserFavorites> findAll();

    /**
     * Get all the userFavorites with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserFavorites> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" userFavorites.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserFavorites> findOne(Long id);

    /**
     * Delete the "id" userFavorites.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
