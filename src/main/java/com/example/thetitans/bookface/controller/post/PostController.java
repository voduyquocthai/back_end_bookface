package com.example.thetitans.bookface.controller.post;

import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.service.user.impl.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@CrossOrigin("*")
public class PostController {

    @Autowired
    private final PostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> getAllPost() {
        Iterable<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        Post post = null;
        Optional<Post> optionalPost = postService.findById(id);
        if(optionalPost.isPresent()){
            post = optionalPost.get();
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.save(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        Post updatePost = postService.save(post);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}