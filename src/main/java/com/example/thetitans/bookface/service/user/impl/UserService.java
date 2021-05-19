package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.UserRepo;
import com.example.thetitans.bookface.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
