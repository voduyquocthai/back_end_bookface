package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.exception.PostNotFoundException;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.repository.PostRepo;
import com.example.thetitans.bookface.service.user.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepo postRepo;

    @Override
    public Page<Post> findAll(Pageable pageable){
        return postRepo.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepo.findAll();
    }
    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);

    }

    @Override
    public void delete(Long id) {
    }
}
