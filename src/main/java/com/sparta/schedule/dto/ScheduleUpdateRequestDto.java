package com.sparta.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class ScheduleUpdateRequestDto {

    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
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
