package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.schedule.dto.ScheduleDeleteRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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

    // 전체 일정조회
    public List<ScheduleResponseDto> findAllSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().sorted(Comparator.comparing(Schedule::getCreatedAt).reversed()).map(ScheduleResponseDto::toDto).toList();
    }

    // 선택한 일정수정
    @Transactional
    public ScheduleResponseDto updateSchedule(long id, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = findById(id);
        if (!schedule.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }
        schedule.updateSchedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getDescription());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 선택한 일정삭제
    @Transactional
    public void deleteSchedule(long id, ScheduleDeleteRequestDto requestDto) {
        Schedule schedule = findById(id);
        if (!Objects.equals(schedule.getPassword(), requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }
        scheduleRepository.delete(schedule);
    }
}
