package com.backend.withFesta.repository;

import com.backend.withFesta.domain.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
    Page<Recruit> findByKeywordContaining(String keyword, Pageable pageable);
    Page<Recruit> findAll(Pageable pageable);
}
