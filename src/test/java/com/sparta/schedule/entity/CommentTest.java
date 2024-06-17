package com.sparta.schedule.entity;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("comment 실패 테스트")
    void commentValidationFailure(){
        //given
        Comment comment = new Comment();
        comment.setUsername("테스트유저");
        comment.setComment(" ");
        //when then
        assertAll(
                () -> assertNotEquals("테스트댓글",comment.getComment(),"댓글을 입력해주세요")
        );

    }

    @Test
    @DisplayName("comment 성공 테스트")
    void commentValidationSuccess(){
        //given
        Comment comment = new Comment();
        comment.setUsername("테스트유저");
        comment.setComment("테스트댓글");
        //when then
        assertAll(
                () -> assertEquals("테스트댓글",comment.getComment(),"댓글을 입력해주세요")
        );

    }

}