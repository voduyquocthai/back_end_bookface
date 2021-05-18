package com.example.thetitans.bookface.model.chat;

import com.example.thetitans.bookface.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User messageSender;

    @ManyToOne
    private User messageReceiver;

    private String content;

    private Instant createdTime;
}
