package com.backend.withFesta.service;
import com.backend.withFesta.domain.Festival;
import com.backend.withFesta.dto.FestivalDTO;
import com.backend.withFesta.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FestivalService {
    private FestivalRepository festivalRepository;

    @Transactional(readOnly = true)
    public Festival findByFestivalId(Long id){
        Festival festival = festivalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 축제입니다."));
        return FestivalDTO.from(festival);
    }
}