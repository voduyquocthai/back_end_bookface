package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.model.chat.Message;
import com.example.thetitans.bookface.service.IGeneralService;

public interface IMessageService extends IGeneralService<Message> {
    Iterable<Message> getAllHistoryBetweenTwoUser(Long userId1, Long userId2, Integer size);

}
