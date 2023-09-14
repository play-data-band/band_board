package com.example.bandboard.repository;

import com.example.bandboard.domain.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Like findByTargetIdAndMemberId(UUID targetId, Long memberId);
}
