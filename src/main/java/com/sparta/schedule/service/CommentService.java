package com.sparta.schedule.service;

import com.sparta.schedule.dto.CommentCreateRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    //댓글 작성
    @Transactional
    public CommentResponseDto createComment(long scheduleId, CommentCreateRequestDto requestDto) {

        // DB에 일정이 존재하지 않는 경우
        Schedule schedule = scheduleService.findById(scheduleId);
        Comment comment = commentRepository.save(new Comment(requestDto.getUsername(), requestDto.getComment(), schedule));
        return CommentResponseDto.toDto(commentRepository.save(comment));
    }

}
