package com.example.thetitans.bookface.controller;

import com.example.thetitans.bookface.model.user.Friendship;
import com.example.thetitans.bookface.service.user.IFriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@AllArgsConstructor
public class FriendShipController {

    private final IFriendshipService friendshipService;

    @PostMapping("/add-waiting")
    public ResponseEntity<?> addFiend(@RequestBody Friendship friendship) {
        friendshipService.save(friendship);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add-accept")
    public ResponseEntity<?> acceptAddFriend(@RequestBody Friendship friendship) {
        friendshipService.save(friendship);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/unfriend/{id}")
    public ResponseEntity<?> unfriend(@PathVariable Long id) {
        friendshipService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
