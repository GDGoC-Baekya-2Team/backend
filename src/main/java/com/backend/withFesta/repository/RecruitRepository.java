package com.backend.withFesta.repository;

import com.backend.withFesta.domain.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
}
