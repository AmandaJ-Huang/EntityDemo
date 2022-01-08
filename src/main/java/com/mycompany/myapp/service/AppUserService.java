package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.AppUser;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link AppUser}.
 */
public interface AppUserService {
    /**
     * Save a appUser.
     *
     * @param appUser the entity to save.
     * @return the persisted entity.
     */
    AppUser save(AppUser appUser);

    /**
     * Partially updates a appUser.
     *
     * @param appUser the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AppUser> partialUpdate(AppUser appUser);

    /**
     * Get all the appUsers.
     *
     * @return the list of entities.
     */
    List<AppUser> findAll();
    /**
     * Get all the AppUser where UserUpload is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<AppUser> findAllWhereUserUploadIsNull();
    /**
     * Get all the AppUser where WatchHistory is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<AppUser> findAllWhereWatchHistoryIsNull();
    /**
     * Get all the AppUser where UserFavorites is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<AppUser> findAllWhereUserFavoritesIsNull();

    /**
     * Get the "id" appUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AppUser> findOne(Long id);

    /**
     * Delete the "id" appUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
