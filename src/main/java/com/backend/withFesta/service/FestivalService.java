package com.backend.withFesta.service;

import com.backend.withFesta.domain.Festival;
import com.backend.withFesta.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FestivalService {
    private FestivalRepository festivalRepository;

    @Transactional
    public List<Festival> search(String keyword){
        return festivalRepository.findByContaining(keyword);
    }
}
