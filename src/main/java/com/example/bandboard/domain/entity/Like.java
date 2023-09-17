package com.example.bandboard.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Setter
@Builder @Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "likes")
public class Like {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID targetId;
    private Long memberId;
}
