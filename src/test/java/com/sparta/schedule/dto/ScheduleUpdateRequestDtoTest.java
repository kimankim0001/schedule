package com.sparta.schedule.dto;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleUpdateRequestDtoTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("password 공백 테스트")
    void password_validation() {
        //given
        ScheduleUpdateRequestDto scheduleUpdateRequestDto =
                ScheduleUpdateRequestDto.builder()
                        .username("테스트유저")
                        .password(" ")
                        .title("테스트제목")
                        .description("테스트내용")
                        .build();
        //when
        Set<ConstraintViolation<ScheduleUpdateRequestDto>> violations = validator.validate(scheduleUpdateRequestDto);
        //then
        for (ConstraintViolation<ScheduleUpdateRequestDto> violation : violations) {
            System.err.println(violation.getMessage());
        }
    }

}