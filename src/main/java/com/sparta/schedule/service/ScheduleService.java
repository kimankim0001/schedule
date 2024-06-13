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

    // 일정작성
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleCreateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.save(requestDto.toEntity());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 선택한 일정조회
    public ScheduleResponseDto findScheduleById(long id) {
        return ScheduleResponseDto.toDto(findById(id));
    }
    protected Schedule findById(long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID에 맞는 일정이 없습니다."));
    }


}
