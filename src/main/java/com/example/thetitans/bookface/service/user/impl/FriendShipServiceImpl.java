package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.user.Friendship;
import com.example.thetitans.bookface.repository.FriendshipRepo;
import com.example.thetitans.bookface.service.user.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendShipServiceImpl implements IFriendshipService {

    @Autowired
    private FriendshipRepo friendshipRepository;

    @Override
    public Iterable<Friendship> findAll() {
        return friendshipRepository.findAll();
    }

    @Override
    public Friendship save(Friendship friendship) {
        return friendshipRepository.save(friendship);
    }

    @Override
    public Friendship findById(Long id) {
        return friendshipRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        friendshipRepository.deleteById(id);
    }
}
