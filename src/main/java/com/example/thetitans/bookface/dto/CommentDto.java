package com.example.thetitans.bookface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String text;
    private Long postId;
    private Instant createdDate;
    private Long userId;
    private String userAvatar;
    private String username;
    private Integer likeCount;
    private Integer heartCount;
    private boolean liked;
    private boolean hearted;
}
