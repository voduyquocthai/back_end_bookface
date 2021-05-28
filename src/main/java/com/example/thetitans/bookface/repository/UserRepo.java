package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(Long id);

    @Query(value = "select * from app_user join friendship on friendship.receiver_user_id = app_user.user_id where friendship.sender_user_id =?1 and friendship.status=true\n" +
            "union all\n" +
            "select * from app_user join friendship on friendship.sender_user_id = app_user.user_id where friendship.receiver_user_id =?1 and friendship.status=true\n", nativeQuery = true)
    Iterable<User> findAllFriend(Long id);

    @Query(value = "SELECT * FROM app_user where enabled = true", nativeQuery = true)
    List<User> findAllUserActivated();

    @Query(value = "SELECT * FROM app_user where enabled = false", nativeQuery = true)
    List<User> findAllUserBlocked();


    @Query(value = "call mutual_friend (:id1,:id2)",nativeQuery = true)
    Iterable<User> getAllMutualFriends(@Param("id1") Long id1, @Param("id2") Long id2);

    @Query(value = "select * from app_user where username like ?1 and enabled = true",nativeQuery = true)
    Page<User> findUserByUsernameLike(String key, PageRequest pageRequest);
}
