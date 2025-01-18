package com.backend.withFesta.validator;

import com.backend.withFesta.domain.dto.UserDto;
import com.backend.withFesta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CustomValidator {

    @RequiredArgsConstructor
    @Component
    public static class EmailValidator extends AbstractValidator<UserDto.Request> {
        private final UserRepository userRepository;

        @Override
        protected void doValidate(UserDto.Request dto, Errors errors) {
            if (userRepository.existsByEmail(dto.toEntity().getEmail())) {
                errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일 입니다.");
            }
        }
    }


    @RequiredArgsConstructor
    @Component
    public static class UsernameValidator extends AbstractValidator<UserDto.Request> {
        private final UserRepository userRepository;

        @Override
        protected void doValidate(UserDto.Request dto, Errors errors) {
            if (userRepository.existsByUsername(dto.toEntity().getUsername())) {
                errors.rejectValue("username", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
            }
        }
    }
}
