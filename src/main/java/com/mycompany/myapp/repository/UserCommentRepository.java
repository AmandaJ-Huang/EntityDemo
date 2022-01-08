package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.UserComment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the UserComment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long> {}
