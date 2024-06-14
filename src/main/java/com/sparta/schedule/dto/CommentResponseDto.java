package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String username;
    private String comment;
    private Long scheduleId;
    private LocalDateTime createdAt;

    public CommentResponseDto(Long id, String username, String comment, Long scheduleId, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.scheduleId = scheduleId;
        this.createdAt = createdAt;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.getUsername(), comment.getComment(), comment.getSchedule().getId(), comment.getCreatedAt());
    }
}
