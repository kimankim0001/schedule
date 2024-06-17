package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceTest {

    @Mock
    ScheduleRepository scheduleRepository;

    @Test
    @DisplayName("일정 수정 테스트")
    void scheduleUpdate(){
        //given
        Long id = 1L;
        ScheduleUpdateRequestDto scheduleUpdateRequestDto =new ScheduleUpdateRequestDto("테스트유저수정후","테스트비밀번호","테스트제목","테스트내용");
        ScheduleService scheduleService = new ScheduleService(scheduleRepository);
        Schedule schedule = new Schedule("테스트유저","테스트비밀번호","테스트제목","테스트내용");
        given(scheduleRepository.findById(id)).willReturn(Optional.of(schedule));
        //when
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id,scheduleUpdateRequestDto);
        //then
        assertEquals("테스트유저수정후", scheduleResponseDto.getUsername());

    }


}