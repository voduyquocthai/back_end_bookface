package com.example.thetitans.bookface.controller.post;

import com.example.thetitans.bookface.dto.EmotionDto;
import com.example.thetitans.bookface.service.user.impl.EmotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emotions")
@AllArgsConstructor
public class EmotionController {
    private final EmotionService emotionService;

    @PostMapping
    public ResponseEntity<Void> emotion(@RequestBody EmotionDto emotionDto) {
        emotionService.vote(emotionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
