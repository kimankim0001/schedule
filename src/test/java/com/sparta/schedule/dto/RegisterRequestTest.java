package com.sparta.schedule.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RegisterRequestTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("username 공백 테스트")
    void username_validation() {
        //given
        RegisterRequest registerRequest =
                RegisterRequest.builder()
                        .username(" ")
                        .password("test1234")
                        .build();
        //when
        Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(registerRequest);
        //then
        for (ConstraintViolation<RegisterRequest> violation : violations) {
            System.err.println(violation.getMessage());
        }
    }


}