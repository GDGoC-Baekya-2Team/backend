package com.backend.withFesta.domain.dto;

import com.backend.withFesta.domain.entity.Recruit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.backend.withFesta.domain.entity.User;

import java.time.LocalDateTime;

public class RecruitDto {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private Long id;
        private String pay;
        private String job;
        private LocalDateTime days;
        private String description;
        private User user;

        /*Dto to Entity*/
        public Recruit toEntity(){
            Recruit recruit = Recruit.builder()
                    .id(id)
                    .pay(pay)
                    .job(job)
                    .days(days)
                    .description(description)
                    .user(user)
                    .build();
            return recruit;
        }

    }

    public static class Response{

    }
}