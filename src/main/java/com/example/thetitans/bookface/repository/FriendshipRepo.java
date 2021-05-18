package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.user.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepo extends JpaRepository<Friendship, Long> {
}
