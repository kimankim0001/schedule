package com.sparta.schedule.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleDeleteRequestDto {

    private String username;

    @NotNull
    private String password;

    public ScheduleDeleteRequestDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
