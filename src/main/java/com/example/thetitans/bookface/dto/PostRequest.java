package com.example.thetitans.bookface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    private String description;
    private int privacy;
    private Integer likeCount;
    private Integer heartCount;
}
