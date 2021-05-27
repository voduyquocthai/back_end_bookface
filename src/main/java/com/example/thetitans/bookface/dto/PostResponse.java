package com.example.thetitans.bookface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String description;
    private String userName;
    private Integer likeCount;
    private Integer heartCount;
    private Integer commentCount;
    private String userAvatar;
    private String duration;
    private boolean liked;
    private boolean hearted;
    private int privacy;
    private Long userId;
}
