package com.example.thetitans.bookface.controller;

import com.example.thetitans.bookface.model.user.Friendship;
import com.example.thetitans.bookface.service.user.IFriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
@AllArgsConstructor
@CrossOrigin("*")
public class FriendShipController {

    private final IFriendshipService friendshipService;

    @PostMapping("/add-waiting")
    public ResponseEntity<Friendship> addFiend(@RequestBody Friendship friendship) {
        friendshipService.save(friendship);
        Friendship friendship1 = friendshipService.findFriendshipBySenderUserIdAndReceiverUserId(
                friendship.getSender().getUserId(),
                friendship.getReceiver().getUserId());
        return new ResponseEntity<Friendship>(friendship1, HttpStatus.OK);
    }

    @PostMapping("/add-accept")
    public ResponseEntity<Friendship> acceptAddFriend(@RequestBody Friendship friendship) {
        Long id1 = friendship.getSender().getUserId();
        Long id2 = friendship.getReceiver().getUserId();
        friendship.setStatus(true);
        friendshipService.save(friendship);
        Friendship friendship1 = friendshipService.searchIfExistFriends(id1, id2);
        return new ResponseEntity<Friendship>(friendship1, HttpStatus.OK);
    }

    @GetMapping("/unfriend/{id}")
    public ResponseEntity<Friendship> unfriend(@PathVariable Long id) {
        friendshipService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{senderUserId}/{receiverUserId}")
    public ResponseEntity<Friendship> searchFriend(@PathVariable Long senderUserId, @PathVariable Long receiverUserId) {
        Friendship friendship = friendshipService.searchIfExistFriends(senderUserId, receiverUserId);
        return new ResponseEntity<Friendship>(friendship, HttpStatus.OK);
    }

    @GetMapping("/listFriends/{receiverId}")
    public ResponseEntity<List<Friendship>> findAllFriendsByReceiverUserId(@PathVariable Long receiverId) {
        List<Friendship> friendships = friendshipService.findAllFriendsByReceiverUserId(receiverId);
        return new ResponseEntity<> (friendships, HttpStatus.OK);
    }
}
