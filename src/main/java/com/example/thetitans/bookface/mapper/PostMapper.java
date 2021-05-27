package com.example.thetitans.bookface.mapper;

import com.example.thetitans.bookface.dto.PostRequest;
import com.example.thetitans.bookface.dto.PostResponse;
import com.example.thetitans.bookface.model.emotion.Emotion;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.CommentRepo;
import com.example.thetitans.bookface.repository.EmotionRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private EmotionRepo emotionRepo;
    @Autowired
    private AuthService authService;


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "likeCount", source = "postRequest.likeCount")
    @Mapping(target = "heartCount", source = "postRequest.heartCount")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "privacy", source = "postRequest.privacy")
    public abstract Post map(PostRequest postRequest, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "userAvatar", source = "user.avatar")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "privacy", source = "privacy")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "liked", expression = "java(isLiked(post))")
    @Mapping(target = "hearted", expression = "java(isHearted(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post){return commentRepo.findAllByPost(post).size();}

    String getDuration(Post post){return TimeAgo.using(post.getCreatedDate().toEpochMilli());}

    boolean isLiked(Post post){return checkEmotionType(post, EmotionType.LIKE);}

    boolean isHearted(Post post){return checkEmotionType(post, EmotionType.HEART);}

    private boolean checkEmotionType(Post post, EmotionType emotionType){
        if (authService.isLoggedIn()) {
            Optional<Emotion> emotionForPostByUser =
                    emotionRepo.findEmotionByPostAndUserAndEmotionType(post,
                            authService.getCurrentUser(),emotionType);
            return emotionForPostByUser
                    .isPresent();
        }
        return false;
    }
}