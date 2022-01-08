package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Genre;
import com.mycompany.myapp.repository.GenreRepository;
import com.mycompany.myapp.service.GenreService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Genre}.
 */
@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        log.debug("Request to save Genre : {}", genre);
        return genreRepository.save(genre);
    }

    @Override
    public Optional<Genre> partialUpdate(Genre genre) {
        log.debug("Request to partially update Genre : {}", genre);

        return genreRepository
            .findById(genre.getId())
            .map(existingGenre -> {
                if (genre.getApiId() != null) {
                    existingGenre.setApiId(genre.getApiId());
                }
                if (genre.getName() != null) {
                    existingGenre.setName(genre.getName());
                }

                return existingGenre;
            })
            .map(genreRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        log.debug("Request to get all Genres");
        return genreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Genre> findOne(Long id) {
        log.debug("Request to get Genre : {}", id);
        return genreRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Genre : {}", id);
        genreRepository.deleteById(id);
    }
}
