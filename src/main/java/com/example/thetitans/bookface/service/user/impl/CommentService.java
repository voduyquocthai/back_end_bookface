package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.dto.CommentDto;
import com.example.thetitans.bookface.exception.PostNotFoundException;
import com.example.thetitans.bookface.mapper.CommentMapper;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.CommentRepo;
import com.example.thetitans.bookface.repository.PostRepo;
import com.example.thetitans.bookface.repository.UserRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import com.example.thetitans.bookface.service.user.ICommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CommentService implements ICommentService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepo commentRepo;

    public void save(CommentDto commentDto) {
        Post post = postRepo.findById(commentDto.getPostId()).
                orElseThrow(() -> new PostNotFoundException(commentDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentDto, post, authService.getCurrentUser());
        commentRepo.save(comment);
    }

    public List<CommentDto> findAllComment() {
        return commentRepo.findAll()
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CommentDto> findByPost(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        List<CommentDto> commentDtosForPost = commentRepo.findAllByPost(post)
                .stream().map(commentMapper::mapToDto)
                .collect(Collectors.toList());
        return commentDtosForPost;
    }

    public List<CommentDto> findAllByUserId(Long userId) {
        User user = userRepo.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId.toString()));
        List<CommentDto> commentDtosForUser = commentRepo.findAllByUser(user)
                .stream().map(commentMapper::mapToDto)
                .collect(Collectors.toList());
        return commentDtosForUser;
    }

    public CommentDto findCommentById(Long commentId) {
        Comment comment = commentRepo.getOne(commentId);
        return commentMapper.mapToDto(comment);
    }

    public void delete(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}
