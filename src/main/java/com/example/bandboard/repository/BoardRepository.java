package com.example.bandboard.repository;

import com.example.bandboard.domain.entity.Board;
import com.example.bandboard.domain.response.BoardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
    @Query("select new com.example.bandboard.domain.response.BoardResponse(b.id,b.title,b.content,b.memberId,b.memberImage,b.memberName, b.likeCount) " +
            "from Board b " +
            "where b.communityId = :communityId ")
    Page<BoardResponse> findBycommunity(@Param("communityId")Long communityId, PageRequest pageRequest);

    @Modifying
    @Query("update Board b " +
            "set b.memberName = :memberName " +
            "where b.memberId = :memberId")
    void updateBoardMemberName(@Param("memberName") String memberName, @Param("memberId") Long memberId);

    @Modifying
    @Query("update Board b " +
            "set b.memberImage = :memberImage " +
            "where b.memberId = :memberId")
    void updateBoardMemberImage( @Param("memberImage") String memberImage, @Param("memberId") Long memberId);

    @Modifying
    @Query("update Board b " +
            "set b.memberImage = :memberImage," +
            "b.memberName = :memberName " +
            "where b.memberId = :memberId")
    void updateBoardMemberImageAndMemberName(@Param("memberName") String memberName, @Param("memberImage") String memberImage, @Param("memberId") Long memberId);

}
