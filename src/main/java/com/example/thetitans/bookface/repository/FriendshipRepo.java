package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
//    @Query(value = "SELECT * FROM bookface.friendship where sender_user_id = ? and receiver_user_id = ?;",nativeQuery = true))
        Friendship findFriendshipBySenderUserIdAndReceiverUserId(Long senderUserId, Long ReceiverUserId);

    @Query(value = "SELECT * FROM friendship where (sender_user_id = ?1 and receiver_user_id = ?2)\n" +
            " or" +
            "\n (receiver_user_id = ?1 and sender_user_id = ?2) limit 1;",nativeQuery = true)
    Friendship searchIfExistFriends(Long senderUserId, Long ReceiverUserId);
}
