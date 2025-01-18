package com.backend.withFesta.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

public class FestivalDto {
    @Getter
    @Data @Builder
    @AllArgsConstructor
    public static class searchDto {
        private Long fstvlId;
        private String fstvlName;
        private String locatioin;
        private String mnnstNm;
        private String fstvlStart;
        private String fstvlEnd;
    }
}
