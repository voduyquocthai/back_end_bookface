package com.example.thetitans.bookface.service.user;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {

    Iterable<User> findFriend(Long id);

    Optional<User> findUserByUsername(String username);


}
