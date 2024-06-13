package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Long id, String username, String title, String description, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getDescription(), schedule.getCreatedAt());
    }
}
