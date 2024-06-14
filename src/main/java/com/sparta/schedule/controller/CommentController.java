package com.sparta.schedule.controller;

import com.sparta.schedule.dto.CommentCreateRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
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
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable(name = "scheduleId") long scheduleId, @Valid @RequestBody CommentCreateRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(scheduleId, requestDto));
    }
}
