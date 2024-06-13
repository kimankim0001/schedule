package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleCreateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.save(requestDto.toEntity());
        return ScheduleResponseDto.toDto(schedule);
    }


}
