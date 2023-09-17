package com.example.bandboard.service;

import com.example.bandboard.domain.entity.Board;
import com.example.bandboard.domain.request.BoardRequest;
import com.example.bandboard.domain.request.MemberUpdateRequest;
import com.example.bandboard.domain.response.BoardResponse;
import com.example.bandboard.repository.BoardRepository;
import com.example.bandboard.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    //여기서 만약에 데이터베이스를 나누면 community에 Board 저장하도록 api 날려야함
    public void save(BoardRequest boardRequest, Long communityId){
        boardRepository.save(boardRequest.toEntity(communityId));
    }

    public void updateBoard(BoardRequest boardRequest, UUID boardId){
        //예외처리 필요하긴 함
        Board board = boardRepository.findById(boardId).get();
        board.setContent(boardRequest.getContent());
        board.setTitle(boardRequest.getTitle());
        boardRepository.save(board);
    }

    //유저가 업데이트 하면 게시판의 멤버 정보도 업데이트 돼야함
    //동적쿼리까지 쓸 필요는 없을 것 같아서 하드코딩함. 하지만 멤버 정보를 더 늘린다면 하드코딩은 부담스럽고 동적쿼리를 써야할 것 같음(mybatis, queryDsl)
    @Transactional
    public void updateBoardMember(MemberUpdateRequest memberUpdateRequest, Long memberId) throws Exception {
        if (memberUpdateRequest.getMemberImage() != null && memberUpdateRequest.getMemberName() !=null ){
            boardRepository.updateBoardMemberImageAndMemberName(memberUpdateRequest.getMemberName(), memberUpdateRequest.getMemberImage(), memberId);
        } else if (memberUpdateRequest.getMemberImage()!=null && memberUpdateRequest.getMemberName() ==null) {
            boardRepository.updateBoardMemberImage(memberUpdateRequest.getMemberImage(),memberId);
        } else if (memberUpdateRequest.getMemberImage()==null && memberUpdateRequest.getMemberName() != null) {
            boardRepository.updateBoardMemberName(memberUpdateRequest.getMemberName(), memberId);
        } else {
            throw new Exception("NULL REQUEST");
        }
    }
    @Transactional
    public void likeCountUpdate(UUID boardId, Integer count) {
        Board board = boardRepository.findById(boardId).get();
        board.setLikeCount(board.getLikeCount() + count);

    }

    public Page<BoardResponse> findBycommunityId(Long communityId, PageRequest pageRequest){
        return boardRepository.findBycommunity(communityId, pageRequest);
    }


    public void deleteByBoardId(UUID boardId){
        boardRepository.deleteById(boardId);
    }


}
