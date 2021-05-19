package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.repository.CommentRepo;
import com.example.thetitans.bookface.service.user.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }
}
