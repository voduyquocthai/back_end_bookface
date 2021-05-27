package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.dto.PostRequest;
import com.example.thetitans.bookface.dto.PostResponse;
import com.example.thetitans.bookface.exception.PostNotFoundException;
import com.example.thetitans.bookface.mapper.PostMapper;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.CommentRepo;
import com.example.thetitans.bookface.repository.EmotionRepo;
import com.example.thetitans.bookface.repository.PostRepo;
import com.example.thetitans.bookface.repository.UserRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import com.example.thetitans.bookface.service.user.IPostService;
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
public class PostService implements IPostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final AuthService authService;
    private final PostMapper postMapper;
    private final EmotionRepo emotionRepo;
    private final CommentRepo commentRepo;

    //method mới sử dụng mapstruct

    public PostResponse save(PostRequest postRequest){
        Post post = postMapper.map(postRequest, authService.getCurrentUser());
        postRepo.save(post);
        return postMapper.mapToDto(post);
    }

    public void delete(Long id){
        emotionRepo.deleteEmotionByPostId(id);
        commentRepo.deleteCommentByPostId(id);
        postRepo.deleteById(id);
    }

    @Transactional(readOnly = true )
    public PostResponse getPostById(Long id){
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true )
    public List<PostResponse> getAllPosts(){
        return postRepo.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true )
    public List<PostResponse> getPostsByUserId(Long id){
        User user = userRepo.findByUserId(id)
                .orElseThrow(() -> new UsernameNotFoundException(id.toString()));
        return postRepo.findAllByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
