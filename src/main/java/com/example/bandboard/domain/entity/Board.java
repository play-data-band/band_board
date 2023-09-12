package com.example.bandboard.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Boards", indexes = {@Index(name = "communityIndex",columnList = "communityId")})
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private String memberImage;
    private String memberName;
    private Long communityId;

}
