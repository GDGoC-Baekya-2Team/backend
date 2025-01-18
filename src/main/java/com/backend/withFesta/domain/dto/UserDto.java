package com.backend.withFesta.domain.dto;


import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import com.backend.withFesta.domain.entity.User;

import java.io.Serializable;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{

        private Long id;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{4,20}$", message = "아이디는 특수문자를 제외한 4~20자리여야 합니다.")
        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String username;

        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        private String email;

        public User toEntity(){
            User user=User.builder()
                    .userId(id)
                    .username(username)
                    .email(email)
                    .build();
            return user;
        }

    }

    @Getter
    public static class Response implements Serializable {
        private final Long id;
        private final String username;
        private final String email;

        public Response(User user){
            this.id = user.getUserId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }

}