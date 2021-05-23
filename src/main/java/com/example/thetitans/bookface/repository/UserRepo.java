package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(Long id);

    @Query(value = "select * from app_user join friendship on friendship.receiver_user_id = app_user.user_id where friendship.sender_user_id =?1 and friendship.status=true\n" +
            "union all\n" +
            "select * from app_user join friendship on friendship.sender_user_id = app_user.user_id where friendship.receiver_user_id =?1 and friendship.status=true\n",nativeQuery = true)
    Iterable<User> findAllFriend(Long id);
}
