package com.backend.withFesta.repository;

import com.backend.withFesta.domain.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long> {
    Page<Recruit> findAll(Pageable pageable);
}
