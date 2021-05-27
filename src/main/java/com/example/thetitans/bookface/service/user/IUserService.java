package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User> {

    Iterable<User> findFriend(Long id);

    Optional<User> findUserByUsername(String username);

    Iterable<User> getAllMutualFriends(Long id1, Long id2);

    Iterable<User> findAll(int page, int size);

    Iterable<User> search(String key,int page, int size);
}
