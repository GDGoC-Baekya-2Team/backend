package com.backend.withFesta.service;

import com.backend.withFesta.converter.FestivalConverter;
import com.backend.withFesta.domain.dto.response.FestivalDto;
import com.backend.withFesta.domain.entity.Festival;
import com.backend.withFesta.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FestivalService {
    private final FestivalRepository festivalRepository;

    public List<FestivalDto.searchDto> search(String name) {
        List<Festival> festivalPage = festivalRepository.findFestivalsByFstvlName(name);
        return festivalPage.stream()
                .map(FestivalConverter::toSearchDto)
                .toList();
    }

    public List<FestivalDto.searchDto> getRecentFestivals() {
        LocalDate before = LocalDate.now().minusMonths(3);
        LocalDate after = LocalDate.now().plusMonths(3);

        List<Festival> festivalList = festivalRepository.findByFstvlStartAfterAndFstvlEndBefore(before, after);
        return festivalList.stream()
                .map(FestivalConverter::toSearchDto)
                .toList();
    }
}