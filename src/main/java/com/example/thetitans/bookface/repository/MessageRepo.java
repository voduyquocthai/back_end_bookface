package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
