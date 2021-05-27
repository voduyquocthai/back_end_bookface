package com.example.thetitans.bookface.service.admin;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private UserRepo userRepo;


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
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<User> findUserByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> fildAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findAllUserActivated() {
        return userRepo.findAllUserActivated();
    }

    @Override
    public List<User> findAllUserBlocked() {
        return userRepo.findAllUserBlocked();
    }

    @Override
    public void blockUserById(Long id) {
        Optional<User> optionalUser = userRepo.findByUserId(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setEnabled(false);
            userRepo.save(user);
        }
    }

    @Override
    public void unBlockUserById(Long id) {
        Optional<User> optionalUser = userRepo.findByUserId(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setEnabled(true);
            userRepo.save(user);
        }
    }

}
