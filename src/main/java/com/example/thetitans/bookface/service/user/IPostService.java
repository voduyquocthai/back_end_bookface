package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.dto.PostRequest;
import com.example.thetitans.bookface.dto.PostResponse;

import java.util.List;

public interface IPostService {
    PostResponse save(PostRequest postRequest);

    void delete(Long id);

    PostResponse getPostById(Long id);

    List<PostResponse> getAllPosts();

    List<PostResponse> getPostsByUserId(Long id);

}
