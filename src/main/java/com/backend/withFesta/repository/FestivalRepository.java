package com.backend.withFesta.repository;

import com.backend.withFesta.domain.entity.Festival;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
//    Page<Festival> findByTitleContaining(String keyword, Pageable pageable);
}
