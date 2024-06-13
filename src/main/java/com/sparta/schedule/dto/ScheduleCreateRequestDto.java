package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleCreateRequestDto {
    private String username;
    private String password;
    private String title;
    private String description;

    public ScheduleCreateRequestDto(String username, String password, String title, String description) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.description = description;
    }

    public Schedule toEntity() {
        return new Schedule(this.username, this.password, this.title, this.description);
    }


}
