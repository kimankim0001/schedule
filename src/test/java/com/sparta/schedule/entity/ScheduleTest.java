package com.sparta.schedule.entity;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("password / title 실패 테스트")
    void passwordTitleValidationSuccess() {
        //given
        Schedule schedule = new Schedule();
        schedule.setUsername("테스트유저");
        schedule.setPassword(" ");
        schedule.setTitle(" ");
        schedule.setDescription("테스트내용");
        //when then
        assertAll(
                () -> assertNotEquals("테스트비밀번호",schedule.getPassword(),"비밀번호를 입력해주세요"),
                () -> assertNotEquals("테스트제목",schedule.getTitle(),"제목을 입력해주세요")
        );

    }

    @Test
    @DisplayName("password / title 성공 테스트")
    void passwordTitleValidationFaileure() {
        //given
        Schedule schedule = new Schedule();
        schedule.setUsername("테스트유저");
        schedule.setPassword("테스트비밀번호");
        schedule.setTitle("테스트제목");
        schedule.setDescription("테스트내용");
        //when then
        assertAll(
                () -> assertEquals("테스트비밀번호",schedule.getPassword(),"비밀번호를 입력해주세요"),
                () -> assertEquals("테스트제목",schedule.getTitle(),"제목을 입력해주세요")
        );

    }

}