package com.backend.withFesta.domain.dto;
import com.backend.withFesta.domain.entity.Recruit;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class RecruitResponseDto {
    private final Long recruitId;
    private final String pay;
    private final String job;
    private final LocalDate days;
    private final String description;
    private final int numOfRecruits;

    public static RecruitResponseDto fromEntity(Recruit recruit) {
        return RecruitResponseDto.builder()
                .recruitId(recruit.getRecruitId())
                .pay(recruit.getPay())
                .job(recruit.getJob())
                .days(recruit.getDays())
                .description(recruit.getDescription())
                .numOfRecruits(recruit.getNumOfRecruits())
                .build();
    }
}
