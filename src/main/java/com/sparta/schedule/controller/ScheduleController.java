package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정작성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleCreateRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(requestDto));
    }

    // 선택한 일정조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok().body(scheduleService.findScheduleById(id));
    }

    // 전체 일정조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule() {
        return ResponseEntity.ok().body(scheduleService.findAllSchedule());
    }

    // 선택한 일정수정
    @PatchMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable(name = "id") long id, @Valid @RequestBody ScheduleCreateRequestDto requestDto){
        return ResponseEntity.ok().body(scheduleService.updateSchedule(id, requestDto));
    }
}
