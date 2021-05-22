package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.emotion.Emotion;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmotionRepo extends JpaRepository<Emotion, Long> {

    Optional<Emotion> findTopByPostAndUserOrderByEmotionIdDesc(Post post, User currentUser);
}
