package com.example.thetitans.bookface.service.admin;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IAdminService extends IGeneralService<User> {

    Optional<User> findUserByUsername(String usernName);

    List<User> findAllUserActivated();

    List<User> findAllUserBlocked();

    void blockUserById(Long id);
}
