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
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
