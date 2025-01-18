package com.backend.withFesta.repository;

import com.backend.withFesta.domain.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {

    @Query("SELECT f FROM Festival f " +
            "WHERE (:name IS NULL OR f.fstvlName LIKE CONCAT('%', :name, '%')) " +
            "ORDER BY f.createdDate DESC")
    List<Festival> findFestivalsByFstvlName(@Param("name") String name);

    List<Festival> findByFstvlStartAfterAndFstvlEndBefore(LocalDate fstvlStartAfter, LocalDate fstvlEndBefore);


}
