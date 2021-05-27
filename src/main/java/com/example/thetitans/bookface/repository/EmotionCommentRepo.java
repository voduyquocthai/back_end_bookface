package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.emotion.EmotionComment;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmotionCommentRepo extends JpaRepository <EmotionComment, Long> {
    Optional<EmotionComment> findEmotionCommentByCommentAndUserAndEmotionType(Comment comment,User currentUser,EmotionType emotionType);
}
