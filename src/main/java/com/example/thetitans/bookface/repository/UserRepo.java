package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(Long id);

    @Query(value = "select * from mxh_bookface.app_user join mxh_bookface.friendship on mxh_bookface.friendship.receiver_user_id = mxh_bookface.user.user_id where mxh_bookface.friendship.sender_user_id =?1 and mxh_bookface.friendship.status=true\n" +
            "union all\n" +
            "select * from mxh_bookface.user join mxh_bookface.friendship on mxh_bookface.friendship.sender_user_id = mxh_bookface.user.user_id where mxh_bookface.friendship.receiver_user_id =?1 and mxh_bookface.friendship.status=true\n",nativeQuery = true)
    Iterable<User> findAllFriend(Long id);
}
