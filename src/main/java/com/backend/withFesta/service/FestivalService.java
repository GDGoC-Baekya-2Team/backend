package com.backend.withFesta.service;

import com.backend.withFesta.domain.entity.Festival;
import com.backend.withFesta.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FestivalService {
    private FestivalRepository festivalRepository;

//    public Page<Festival> searchTitle(String keyword, Pageable pageable){
//        return festivalRepository.findByTitleContaining(keyword, pageable);
//    }

    public Festival FindByFestivalId(Long id){
        return festivalRepository.findById(id)
                .orElse(null);
    }
}