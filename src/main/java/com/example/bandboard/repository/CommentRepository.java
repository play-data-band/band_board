package com.example.bandboard.repository;

import com.example.bandboard.domain.entity.Comment;
import com.example.bandboard.domain.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new com.example.bandboard.domain.response.CommentResponse(c) " +
            "from Comment c " +
            "where c.targetId = :targetId")
    List<CommentResponse> findAllByTargetId(@Param("targetId")UUID targetId);

}
