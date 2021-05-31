package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.chat.Message;
import com.example.thetitans.bookface.repository.MessageRepo;
import com.example.thetitans.bookface.service.user.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Message> findAll() {
        return messageRepo.findAll();
    }

    @Override
    public Message save(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        messageRepo.deleteById(id);
    }

    @Override
    public Iterable<Message> getAllHistoryBetweenTwoUser(Long userId1, Long userId2, Integer size) {
        return messageRepo.getAllHistoryBetweenTwoUser(userId1, userId2, size);
    }
}
