package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);
}
