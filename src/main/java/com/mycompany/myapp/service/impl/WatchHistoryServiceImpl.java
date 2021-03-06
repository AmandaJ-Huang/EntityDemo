package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.WatchHistory;
import com.mycompany.myapp.repository.WatchHistoryRepository;
import com.mycompany.myapp.service.WatchHistoryService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link WatchHistory}.
 */
@Service
@Transactional
public class WatchHistoryServiceImpl implements WatchHistoryService {

    private final Logger log = LoggerFactory.getLogger(WatchHistoryServiceImpl.class);

    private final WatchHistoryRepository watchHistoryRepository;

    public WatchHistoryServiceImpl(WatchHistoryRepository watchHistoryRepository) {
        this.watchHistoryRepository = watchHistoryRepository;
    }

    @Override
    public WatchHistory save(WatchHistory watchHistory) {
        log.debug("Request to save WatchHistory : {}", watchHistory);
        return watchHistoryRepository.save(watchHistory);
    }

    @Override
    public Optional<WatchHistory> partialUpdate(WatchHistory watchHistory) {
        log.debug("Request to partially update WatchHistory : {}", watchHistory);

        return watchHistoryRepository
            .findById(watchHistory.getId())
            .map(existingWatchHistory -> {
                if (watchHistory.getDateWatched() != null) {
                    existingWatchHistory.setDateWatched(watchHistory.getDateWatched());
                }

                return existingWatchHistory;
            })
            .map(watchHistoryRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WatchHistory> findAll() {
        log.debug("Request to get all WatchHistories");
        return watchHistoryRepository.findAllWithEagerRelationships();
    }

    public Page<WatchHistory> findAllWithEagerRelationships(Pageable pageable) {
        return watchHistoryRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<WatchHistory> findOne(Long id) {
        log.debug("Request to get WatchHistory : {}", id);
        return watchHistoryRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete WatchHistory : {}", id);
        watchHistoryRepository.deleteById(id);
    }
}
