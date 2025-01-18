package com.backend.withFesta.domain.dto;

import com.backend.withFesta.domain.entity.Recruit;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruitRequestDto {
    private String pay;
    private String job;
    private LocalDate days;
    private String description;
    private int numOfRecruits;

    public Recruit toEntity() {
        return Recruit.builder()
                .pay(pay)
                .job(job)
                .days(days)
                .description(description)
                .numOfRecruits(numOfRecruits)
                .build();
    }
}
