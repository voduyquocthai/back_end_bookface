package com.example.thetitans.bookface.model.chat;

import com.example.thetitans.bookface.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @ManyToOne
    private User firstUser;

    @ManyToOne
    private User secondUser;

    private String name;
}
