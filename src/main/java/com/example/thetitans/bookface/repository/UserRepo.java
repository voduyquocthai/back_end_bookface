package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query(value = "select * from bookface.user join bookface.friendship on bookface.friendship.receiver_user_id = bookface.user.user_id where bookface.friendship.sender_user_id =?1 and bookface.friendship.status=true\n" +
            "union all\n" +
            "select * from bookface.user join bookface.friendship on bookface.friendship.sender_user_id = bookface.user.user_id where bookface.friendship.receiver_user_id =?1 and bookface.friendship.status=true\n",nativeQuery = true)
    Iterable<User> findAllFriend(Long id);
}
