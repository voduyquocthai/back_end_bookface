package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long> {
}
