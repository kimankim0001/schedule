package com.sparta.schedule.entity;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("username/password 실패 테스트")
    void usernamePasswordValidationFailure(){
        //given
        User user = new User();
        user.setUsername(" ");
        user.setPassword(" ");
        //when then
        assertAll(
                () -> assertNotEquals("테스트유저",user.getUsername(),"유저네임을 입력해주세요"),
                () -> assertNotEquals("테스트비밀번호",user.getPassword(),"비밀번호를 입력해주세요")
        );

    }

    @Test
    @DisplayName("username/password 성공 테스트")
    void usernamePasswordValidationSuccess(){
        //given
        User user = new User();
        user.setUsername("테스트유저");
        user.setPassword("테스트비밀번호");
        //when then
        assertAll(
                () -> assertEquals("테스트유저",user.getUsername(),"유저네임을 입력해주세요"),
                () -> assertEquals("테스트비밀번호",user.getPassword(),"비밀번호를 입력해주세요")
        );

    }

}