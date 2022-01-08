package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.UserUpload;
import com.mycompany.myapp.repository.UserUploadRepository;
import com.mycompany.myapp.service.UserUploadService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserUpload}.
 */
@Service
@Transactional
public class UserUploadServiceImpl implements UserUploadService {

    private final Logger log = LoggerFactory.getLogger(UserUploadServiceImpl.class);

    private final UserUploadRepository userUploadRepository;

    public UserUploadServiceImpl(UserUploadRepository userUploadRepository) {
        this.userUploadRepository = userUploadRepository;
    }

    @Override
    public UserUpload save(UserUpload userUpload) {
        log.debug("Request to save UserUpload : {}", userUpload);
        return userUploadRepository.save(userUpload);
    }

    @Override
    public Optional<UserUpload> partialUpdate(UserUpload userUpload) {
        log.debug("Request to partially update UserUpload : {}", userUpload);

        return userUploadRepository
            .findById(userUpload.getId())
            .map(existingUserUpload -> {
                if (userUpload.getDateUploaded() != null) {
                    existingUserUpload.setDateUploaded(userUpload.getDateUploaded());
                }

                return existingUserUpload;
            })
            .map(userUploadRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserUpload> findAll() {
        log.debug("Request to get all UserUploads");
        return userUploadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserUpload> findOne(Long id) {
        log.debug("Request to get UserUpload : {}", id);
        return userUploadRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserUpload : {}", id);
        userUploadRepository.deleteById(id);
    }
}
