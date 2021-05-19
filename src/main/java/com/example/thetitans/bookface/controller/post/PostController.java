package com.example.thetitans.bookface.controller.post;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.service.user.impl.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    //region api status post
    @PostMapping
    @ResponseBody
    public ResponseEntity<Post> createStatus(@RequestBody Post post) {
        Post status = postService.save(post);
        return new ResponseEntity(status, HttpStatus.CREATED);
    }
}
