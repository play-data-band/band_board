package com.example.bandboard.controller;

import com.example.bandboard.domain.request.BoardRequest;
import com.example.bandboard.domain.request.MemberUpdateRequest;
import com.example.bandboard.domain.response.BoardResponse;
import com.example.bandboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController{
    private final BoardService boardService;

    @GetMapping("/{communityId}")
    public Page<BoardResponse> findBycommunityId(
            @PathVariable("communityId")Long communityId,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size
                                                 ){
        return boardService.findBycommunityId(communityId,PageRequest.of(page,size));
    }

    @PutMapping("/{boardId}")
    public void updateBoard(@PathVariable("boardId") UUID boardId,
                            @RequestBody BoardRequest boardRequest){
        boardService.updateBoard(boardRequest, boardId);
    }

    @PutMapping("/updatemember/{memberId}")
    public void updateMemberBoard(@PathVariable("memberId")Long memberId,
                                  @RequestBody MemberUpdateRequest memberUpdateRequest) throws Exception {
        boardService.updateBoardMember(memberUpdateRequest, memberId);
    }

    @PutMapping("/likeCountUpdate/{boardId}")
    public void updateLikeCount(@PathVariable("boardId") UUID boardId,
                                @RequestBody Integer count) {
        boardService.likeCountUpdate(boardId, count);
    }

    @PostMapping("/{communityId}")
    public void saveBoard(@PathVariable("communityId")Long communityId,
                          @RequestBody BoardRequest boardRequest){
        boardService.save(boardRequest,communityId);
    }

    //프론트단에서 memberId로 삭제 권한 부여됨
    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable("boardId")UUID boardId){
        boardService.deleteByBoardId(boardId);
    }


}
