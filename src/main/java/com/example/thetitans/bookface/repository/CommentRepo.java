package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
