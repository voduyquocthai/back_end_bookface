package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.user.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserService implements IUserService {
    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
