package com.example.thetitans.bookface.controller.user;

import com.example.thetitans.bookface.model.chat.Message;
import com.example.thetitans.bookface.service.user.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class WebSocketController {

    @Autowired
    private IMessageService messageService;

    @MessageMapping("/chats")
    @SendTo("/topic/chats")
    public Message chatting(Message message) {
        message.setCreatedTime(java.time.Instant.now());
        messageService.save(message);
        return message;
    }
}
