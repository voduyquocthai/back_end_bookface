package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
