package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.dto.EmotionCommentDto;
import com.example.thetitans.bookface.exception.CommentNotFoundException;
import com.example.thetitans.bookface.model.emotion.EmotionComment;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.repository.CommentRepo;
import com.example.thetitans.bookface.repository.EmotionCommentRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.thetitans.bookface.model.emotion.EmotionType.HEART;
import static com.example.thetitans.bookface.model.emotion.EmotionType.LIKE;
@Service
@AllArgsConstructor
public class EmotionCommentService {

    private final EmotionCommentRepo emotionCommentRepo;
    private final CommentRepo commentRepo;
    private final AuthService authService;

    @Transactional
    public void voteComment(EmotionCommentDto emotionCommentDto) {
        Comment comment = commentRepo.findById(emotionCommentDto.getCommentId())
                .orElseThrow(() -> new CommentNotFoundException("Comment Not Found with ID - " + emotionCommentDto.getCommentId()));
        Optional<EmotionComment> emotionByCommentAndUserAndEmotionType = emotionCommentRepo.findEmotionCommentByCommentAndUserAndEmotionType(comment, authService.getCurrentUser(), emotionCommentDto.getEmotionType());
        if(emotionByCommentAndUserAndEmotionType.isPresent()) {
            EmotionType emotionType = emotionByCommentAndUserAndEmotionType.get().getEmotionType();
            if (LIKE.equals(emotionType)) {
                comment.setLikeCount(comment.getLikeCount() - 1);
            }
            if(HEART.equals(emotionType)){
                comment.setHeartCount(comment.getHeartCount() -1);
            }
            emotionCommentRepo.deleteById(emotionByCommentAndUserAndEmotionType.get().getEmotionCommentId());
        } else {
            if(LIKE.equals(emotionCommentDto.getEmotionType())){
                comment.setLikeCount(comment.getLikeCount() + 1);
            }
            if(HEART.equals(emotionCommentDto.getEmotionType())){
                comment.setHeartCount(comment.getHeartCount() + 1);
            }
            emotionCommentRepo.save(mapToEmotionComment(emotionCommentDto, comment));
        }
        commentRepo.save(comment);
    }

    private EmotionComment mapToEmotionComment(EmotionCommentDto emotionCommentDto, Comment comment) {
        return EmotionComment.builder()
                .emotionType(emotionCommentDto.getEmotionType())
                .comment(comment)
                .user(authService.getCurrentUser())
                .build();
    }
}
