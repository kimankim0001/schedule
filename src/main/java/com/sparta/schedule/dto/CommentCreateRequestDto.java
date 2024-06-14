package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {

    private String username;
    private String comment;

    public CommentCreateRequestDto(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }
}
