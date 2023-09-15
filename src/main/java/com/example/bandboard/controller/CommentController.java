package com.example.bandboard.controller;

import com.example.bandboard.domain.entity.Comment;
import com.example.bandboard.domain.request.CommentRequest;
import com.example.bandboard.domain.response.CommentResponse;
import com.example.bandboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public void save(@RequestBody CommentRequest request) {
        commentService.save(request);
    }

    @DeleteMapping("{commentId}")
    public void deleteById(@PathVariable("commentId") Long id) {
        commentService.deleteById(id);
    }

    @GetMapping("{targetId}")
    public List<Comment> getAll(@PathVariable("targetId") UUID targetId) {
        return commentService.findAllByTargetId(targetId);
    }

    @PutMapping("{commentId}")
    public void updateComment(@PathVariable("commentId") Long commentId,
                              @RequestBody CommentRequest request) {
        commentService.updateComment(commentId, request);
    }
}
