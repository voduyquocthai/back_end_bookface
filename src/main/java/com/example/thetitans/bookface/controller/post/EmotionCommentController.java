package com.example.thetitans.bookface.controller.post;

import com.example.thetitans.bookface.dto.EmotionCommentDto;
import com.example.thetitans.bookface.service.user.impl.EmotionCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emotions-comment")
@AllArgsConstructor
public class EmotionCommentController {
    private final EmotionCommentService emotionCommentService;

    @PostMapping
    public ResponseEntity<Void> emotionComment(@RequestBody EmotionCommentDto emotionCommentDto) {
        emotionCommentService.voteComment(emotionCommentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
