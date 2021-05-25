package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.dto.EmotionDto;
import com.example.thetitans.bookface.exception.PostNotFoundException;
import com.example.thetitans.bookface.model.emotion.Emotion;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.repository.EmotionRepo;
import com.example.thetitans.bookface.repository.PostRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.thetitans.bookface.model.emotion.EmotionType.HEART;
import static com.example.thetitans.bookface.model.emotion.EmotionType.LIKE;

@Service
@AllArgsConstructor
public class EmotionService {

    private final EmotionRepo emotionRepo;
    private final PostRepo postRepo;
    private final AuthService authService;

    @Transactional
    public void vote(EmotionDto emotionDto) {
        Post post = postRepo.findById(emotionDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + emotionDto.getPostId()));
        Optional<Emotion> emotionByPostAndUserAndEmotionType = emotionRepo.findEmotionByPostAndUserAndEmotionType(post, authService.getCurrentUser(), emotionDto.getEmotionType());
        if(emotionByPostAndUserAndEmotionType.isPresent()) {
            EmotionType emotionType = emotionByPostAndUserAndEmotionType.get().getEmotionType();
            if (LIKE.equals(emotionType)) {
                post.setLikeCount(post.getLikeCount() - 1);
            }
            if(HEART.equals(emotionType)){
                post.setHeartCount(post.getHeartCount() -1);
            }
            emotionRepo.deleteById(emotionByPostAndUserAndEmotionType.get().getEmotionId());
        } else {
            if(LIKE.equals(emotionDto.getEmotionType())){
                post.setLikeCount(post.getLikeCount() + 1);
            }
            if(HEART.equals(emotionDto.getEmotionType())){
                post.setHeartCount(post.getHeartCount() + 1);
            }
            emotionRepo.save(mapToEmotion(emotionDto, post));
        }
        postRepo.save(post);
    }

    private Emotion mapToEmotion(EmotionDto emotionDto, Post post) {
        return Emotion.builder()
                .emotionType(emotionDto.getEmotionType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }


}
