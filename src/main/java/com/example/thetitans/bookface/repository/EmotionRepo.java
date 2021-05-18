package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.emotion.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepo extends JpaRepository<Emotion, Long> {
}
