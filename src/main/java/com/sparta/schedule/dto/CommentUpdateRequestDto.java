package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

    private String username;
    private String comment;

    public CommentUpdateRequestDto(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }
}
