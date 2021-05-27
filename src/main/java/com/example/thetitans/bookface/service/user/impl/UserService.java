package com.example.thetitans.bookface.service.user.impl;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.UserRepo;
import com.example.thetitans.bookface.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }


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

    @Override

    public Iterable<User> findFriend(Long id) {
        return userRepo.findAllFriend(id);
    }
    @Transactional
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Iterable<User> getAllMutualFriends(Long id1, Long id2) {
        return userRepo.getAllMutualFriends(id1, id2);
    }
  
    @Override
    public Iterable<User> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> userPage = userRepo.findAll(pageRequest);
        return userPage.getContent();
    }

    @Override
    public Iterable<User> search(String key, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> userPage = userRepo.findUserByUsernameLike("%" + key + "%", pageRequest);
        return userPage.getContent();
    }
}
