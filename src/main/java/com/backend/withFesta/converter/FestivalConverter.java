package com.backend.withFesta.converter;

import com.backend.withFesta.domain.dto.response.FestivalDto;
import com.backend.withFesta.domain.entity.Festival;

public class FestivalConverter {
    public static FestivalDto.searchDto toSearchDto(Festival festival) {
        return FestivalDto.searchDto.builder()
                .fstvlId(festival.getFestivalId())
                .fstvlName(festival.getFstvlName())
                .locatioin(festival.getLocation())
                .rdnmadr(festival.getRdnmadr())
                .fstvlEnd(festival.getFstvlEnd().toString())
                .fstvlStart(festival.getFstvlStart().toString())
                .mnnstNm(festival.getMnnstNm())
                .imageUrl(festival.getImageUrl())
                .build();
    }
}
