package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class CommentDeleteRequestDto {

    private String username;
    private String comment;

    public CommentDeleteRequestDto(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

}
