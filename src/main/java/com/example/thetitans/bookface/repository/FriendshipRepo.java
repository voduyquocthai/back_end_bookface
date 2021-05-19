package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
}
