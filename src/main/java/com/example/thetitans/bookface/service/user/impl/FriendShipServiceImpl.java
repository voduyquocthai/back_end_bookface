package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.user.Friendship;
import com.example.thetitans.bookface.repository.FriendshipRepo;
import com.example.thetitans.bookface.service.user.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FriendShipServiceImpl implements IFriendshipService {

    @Autowired
    private FriendshipRepo friendshipRepository;

    @Override
    public Page<Friendship> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Friendship> findAll() {
        return friendshipRepository.findAll();
    }

    @Override
    public Friendship save(Friendship friendship) {
        return friendshipRepository.save(friendship);
    }

    @Override
    public Optional<Friendship> findById(Long id) {
        return friendshipRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        friendshipRepository.deleteById(id);
    }

    @Override
    public Friendship findFriendshipBySenderUserIdAndReceiverUserId(Long senderUserId, Long ReceiverId) {
        return friendshipRepository.findFriendshipBySenderUserIdAndReceiverUserId(senderUserId,ReceiverId);
    }
    @Transactional
    @Override
    public Friendship searchIfExistFriends(Long senderUserId, Long ReceiverUserId) {
        return friendshipRepository.searchIfExistFriends(senderUserId,ReceiverUserId);
    }

    @Override
    public List<Friendship> findAllFriendsByReceiverUserId(Long id) {
        return friendshipRepository.findAllFriendsByReceiverUserId(id);
    }
}
