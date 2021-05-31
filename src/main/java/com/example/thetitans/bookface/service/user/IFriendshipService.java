package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.model.user.Friendship;
import com.example.thetitans.bookface.service.IGeneralService;

import java.util.List;

public interface IFriendshipService extends IGeneralService<Friendship> {
    Friendship findFriendshipBySenderUserIdAndReceiverUserId(Long senderUserId, Long ReceiverUserId);
    Friendship searchIfExistFriends(Long senderUserId, Long ReceiverUserId);
    List<Friendship> findAllFriendsByReceiverUserId(Long id);
}
