package com.sparta.schedule.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private String username;

    @NotNull
    private String password;

    private String title;

    private String description;

    public ScheduleUpdateRequestDto(String username, String password, String title, String description){
        this.username = username;
        this.password = password;
        this.title = title;
        this.description = description;
    }
}
