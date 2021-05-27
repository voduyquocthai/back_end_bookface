package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.emotion.EmotionComment;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmotionCommentRepo extends JpaRepository <EmotionComment, Long> {
    Optional<EmotionComment> findEmotionCommentByCommentAndUserAndEmotionType(Comment comment,User currentUser,EmotionType emotionType);

    @Modifying
    @Query(value = "DELETE FROM emotion_comment WHERE comment_id=?1", nativeQuery = true)
    void deleteEmotionCommentByCommentId(Long commentId);
}
