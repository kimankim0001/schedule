package com.sparta.schedule.controller;

import com.sparta.schedule.dto.CommentCreateRequestDto;
import com.sparta.schedule.dto.CommentDeleteRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.dto.CommentUpdateRequestDto;
import com.sparta.schedule.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules/{scheduleId}")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comments")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable(name = "scheduleId") long scheduleId, @Valid @RequestBody CommentCreateRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(scheduleId, requestDto));
    }

    //선택한 댓글 수정
    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable(name = "scheduleId") long scheduleId, @PathVariable(name = "commentId") long commentId, @Valid @RequestBody CommentUpdateRequestDto requestDto) {
        return ResponseEntity.ok().body(commentService.updateComment(scheduleId, commentId, requestDto));
    }

    //선택한 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(name = "scheduleId") long scheduleId, @PathVariable(name = "commentId") long commentId, @Valid @RequestBody CommentDeleteRequestDto requestDto) {
        commentService.deleteComment(scheduleId, commentId, requestDto);
        return ResponseEntity.ok().body("성공적으로 댓글이 삭제되었습니다.");
    }
}
