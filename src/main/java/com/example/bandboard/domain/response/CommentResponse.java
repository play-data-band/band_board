package com.example.bandboard.domain.response;

import com.example.bandboard.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String content;
    private UUID targetId;
    private Long memberId;
    private String memberImage;
    private String memberName;

}
