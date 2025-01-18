package com.backend.withFesta.domain.dto;

import com.backend.withFesta.domain.entity.Recruit;
import lombok.*;
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
                    .recruitId(id)
                    .pay(pay)
                    .job(job)
                    .days(days)
                    .description(description)
                    .user(user)
                    .build();
            return recruit;
        }
    }

    @Getter
    public static class Response{
        private final Long id;
        private final String pay;
        private final String job;
        private final LocalDateTime days;
        private final String description;
        private final User user;

        // Entity to DTo
        public Response(Recruit recruit){
            this.id=recruit.getRecruitId();
            this.pay=recruit.getPay();
            this.job=recruit.getJob();
            this.days=recruit.getDays();
            this.description=recruit.getDescription();
            this.user=recruit.getUser();
        }
    }
}