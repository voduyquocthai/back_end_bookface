package com.example.thetitans.bookface.mapper;

import com.example.thetitans.bookface.dto.CommentDto;
import com.example.thetitans.bookface.model.emotion.EmotionComment;
import com.example.thetitans.bookface.model.emotion.EmotionType;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import com.example.thetitans.bookface.repository.EmotionCommentRepo;
import com.example.thetitans.bookface.service.security.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    @Autowired
    private AuthService authService;
    @Autowired
    private EmotionCommentRepo emotionCommentRepo;

    @Mapping(target = "id", source = "commentDto.id")
    @Mapping(target = "text", source = "commentDto.text")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "heartCount", constant = "0")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
    public abstract Comment map(CommentDto commentDto, Post post, User user);

    @Mapping(target ="postId",expression = "java(comment.getPost().getPostId())")
    @Mapping(target ="userId",expression = "java(comment.getUser().getUserId())")
    @Mapping(target ="username",expression = "java(comment.getUser().getUsername())")
    @Mapping(target ="userAvatar",expression = "java(comment.getUser().getAvatar())")
    @Mapping(target = "liked", expression = "java(isLiked(comment))")
    @Mapping(target = "hearted", expression = "java(isHearted(comment))")
    public abstract CommentDto mapToDto(Comment comment);

    boolean isLiked(Comment comment){return checkEmotionType(comment, EmotionType.LIKE);}
    boolean isHearted(Comment comment){return checkEmotionType(comment, EmotionType.HEART);}

    private boolean checkEmotionType(Comment comment, EmotionType emotionType) {
        if (authService.isLoggedIn()) {
            Optional<EmotionComment> emotionForCommentByUser =
                    emotionCommentRepo.findEmotionCommentByCommentAndUserAndEmotionType(comment,
                            authService.getCurrentUser(),emotionType);
            return emotionForCommentByUser.isPresent();
        }
        return false;
    }
}
