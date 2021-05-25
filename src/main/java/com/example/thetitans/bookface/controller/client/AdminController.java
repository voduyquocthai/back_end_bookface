package com.example.thetitans.bookface.controller.client;

import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.service.admin.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/search/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username){
        Optional<User> userOptional = adminService.findUserByUsername(username);
        if(userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user-activated")
    public ResponseEntity<List<User>> findAllUserActivated(){
        List<User> users = adminService.findAllUserActivated();
          return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping("/user-blocked")
    public ResponseEntity<List<User>> findAllUserBlocked(){
        List<User> users = adminService.findAllUserBlocked();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping("/user-block/{id}")
    public ResponseEntity<User> update(@PathVariable Long id){
        adminService.blockUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
