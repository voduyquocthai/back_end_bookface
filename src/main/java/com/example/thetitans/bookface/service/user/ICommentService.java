package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.dto.CommentDto;

import java.util.List;

public interface ICommentService {
    List<CommentDto> findAllComment();

    List<CommentDto> findByPost(Long postId);

    List<CommentDto> findAllByUserId(Long userId);

    void save(CommentDto commentDto);

    CommentDto findCommentById(Long commentId);

    void delete(Long id);
}
