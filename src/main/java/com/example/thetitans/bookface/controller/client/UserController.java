package com.example.thetitans.bookface.controller.client;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username){
        Optional<User> userOptional = userService.findUserByUsername(username);
        if(userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user-profile/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-profile/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            user.setRole(userOptional.get().getRole());
            if (user.getAvatar() == null){
                user.setAvatar(userOptional.get().getAvatar());
            }
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list-friend/{id}")
    public ResponseEntity<Iterable<User>> friend(@PathVariable Long id){
        return new ResponseEntity<>(userService.findFriend(id),HttpStatus.OK);
    }


    @GetMapping("/mutual-friends/{userId1}/{userId2}")
    public ResponseEntity<Iterable<User>> getAllMutualFriends(@PathVariable("userId1") Long id1, @PathVariable("userId2") Long id2){
        return new ResponseEntity<>(userService.getAllMutualFriends(id1,id2),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<User>> searchUserByKey(@RequestParam("key") String key, @RequestParam("page") int page, @RequestParam("size") int size){
        Iterable<User> users = userService.search(key, page, size);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
