package com.example.bandboard.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class BoardResponse {
    private UUID id;
    private String title;
    private String content;
    private Long memberId;
    private String memberImage;
    private String memberName;
    private int likeCount;

}
