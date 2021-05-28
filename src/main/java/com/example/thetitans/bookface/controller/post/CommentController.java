package com.example.thetitans.bookface.controller.post;

import com.example.thetitans.bookface.dto.CommentDto;
import com.example.thetitans.bookface.service.user.impl.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComment() {
        return status(HttpStatus.OK).body(commentService.findAllComment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
        return status(HttpStatus.OK).body(commentService.findCommentById(id));
    }
    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentForPost(@PathVariable Long postId) {
        return new ResponseEntity<>(commentService.findByPost(postId), HttpStatus.OK);
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CommentDto>> getAllCommentForUser(@PathVariable Long userId) {
        return new ResponseEntity<>(commentService.findAllByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {

        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}