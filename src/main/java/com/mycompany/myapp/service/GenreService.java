package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Genre;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Genre}.
 */
public interface GenreService {
    /**
     * Save a genre.
     *
     * @param genre the entity to save.
     * @return the persisted entity.
     */
    Genre save(Genre genre);

    /**
     * Partially updates a genre.
     *
     * @param genre the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Genre> partialUpdate(Genre genre);

    /**
     * Get all the genres.
     *
     * @return the list of entities.
     */
    List<Genre> findAll();

    /**
     * Get the "id" genre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Genre> findOne(Long id);

    /**
     * Delete the "id" genre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
