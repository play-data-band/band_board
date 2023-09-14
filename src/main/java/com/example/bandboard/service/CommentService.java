package com.example.bandboard.service;

import com.example.bandboard.domain.entity.Comment;
import com.example.bandboard.domain.request.CommentRequest;
import com.example.bandboard.domain.response.CommentResponse;
import com.example.bandboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentRequest request) {
        Comment comment = Comment.builder()
                .content(request.getContent())
                .targetId(request.getTargetId())
                .build();
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentResponse> findAll(UUID targetId) {
        return commentRepository.findAllByTargetId(targetId);
    }

    public void updateComment(Long commentId, CommentRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(request.getContent());
        commentRepository.save(comment);

    }

}
