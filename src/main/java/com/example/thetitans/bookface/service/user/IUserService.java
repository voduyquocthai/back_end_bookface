package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {

    Optional<User> findUserByUsername(String username);
    Iterable<User> findFriend(Long id);
}
