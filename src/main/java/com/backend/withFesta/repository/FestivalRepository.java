package com.backend.withFesta.repository;

import com.backend.withFesta.domain.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
    List<Festival> findByContaining(String keyword);
}
