package com.example.thetitans.bookface.dto;

import com.example.thetitans.bookface.model.emotion.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmotionDto {
    private EmotionType emotionType;
    private Long postId;

}
