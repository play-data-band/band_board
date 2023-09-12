package com.example.bandboard.domain.request;


import com.example.bandboard.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardRequest {
    private String title;
    private String content;
    private Long memberId;
    private String memberName;
    private String memberImage;


    public Board toEntity(Long communityId){
        return Board.builder()
                .title(title)
                .content(content)
                .memberId(memberId)
                .memberName(memberName)
                .communityId(communityId)
                .build();
    }
}
