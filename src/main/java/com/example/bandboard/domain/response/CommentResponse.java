package com.example.bandboard.domain.response;

import com.example.bandboard.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long commentId;
    private String content;
    private String memberImage;
    private String memberName;

    public CommentResponse(Comment comment){
        this.commentId = comment.getId();
        this.content = comment.getContent();
        this.memberImage = comment.getMemberImage();
        this.memberName = comment.getMemberName();
    }
}
