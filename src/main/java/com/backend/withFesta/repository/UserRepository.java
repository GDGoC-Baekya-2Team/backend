package com.backend.withFesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.withFesta.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /* Security */
    Optional<User> findByUsername(String username);

    /* OAuth */
    Optional<User> findByEmail(String email);

    /* 중복 검사> 중복인 경우 true, 중복되지 않은경우 false 리턴 */
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
