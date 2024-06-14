package com.sparta.schedule.service;

import com.sparta.schedule.dto.CommentCreateRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.dto.CommentUpdateRequestDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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

    //선택한 댓글 수정
    @Transactional
    public CommentResponseDto updateComment(long scheduleId, long commentId, CommentUpdateRequestDto requestDto) {

        // DB에 일정이 존재하지 않는 경우
        scheduleService.findById(scheduleId);
        // DB에 댓글이 존재하지 않는 경우
        Comment comment = findCommentById(commentId);
        // 댓글 작성자와 사용자가 일치하지 않는 경우
        if (!Objects.equals(comment.getUsername(), requestDto.getUsername())) {
            throw new IllegalArgumentException("선택한 댓글의 사용자가 현재 사용자와 불일치합니다");
        }
        comment.updateComment(requestDto.getComment());
        return CommentResponseDto.toDto(comment);
    }

    // 댓글 존재하는지 체크하는 메서드
    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 ID에 맞는 댓글이 없습니다"));
    }


}
