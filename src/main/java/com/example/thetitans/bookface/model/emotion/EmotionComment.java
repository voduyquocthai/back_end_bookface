package com.example.thetitans.bookface.model.emotion;

import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.user.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmotionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emotionCommentId;

    private EmotionType emotionType;

    @NotNull
    @ManyToOne(fetch = EAGER)
    private Comment comment;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
