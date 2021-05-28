package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);
    List<Comment> findAllByUser(User user);

    @Modifying
    @Query(value = "DELETE FROM comment WHERE post_id=?1", nativeQuery = true)
    void deleteCommentByPostId(Long postId);

}
