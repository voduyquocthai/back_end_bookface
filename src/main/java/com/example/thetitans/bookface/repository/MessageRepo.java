package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query(value = "call mxh_bookface.getAllChatBetweenTwoUser(:user1Id,:user2Id,:size)", nativeQuery = true)
    Iterable<Message> getAllHistoryBetweenTwoUser(Long user1Id, Long user2Id, Integer size);
}
