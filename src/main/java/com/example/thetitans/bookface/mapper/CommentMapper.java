package com.example.thetitans.bookface.mapper;

import com.example.thetitans.bookface.dto.CommentDto;
import com.example.thetitans.bookface.model.post.Comment;
import com.example.thetitans.bookface.model.post.Post;
import com.example.thetitans.bookface.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    @Mapping(target = "id", source = "commentDto.id")
    @Mapping(target = "text", source = "commentDto.text")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
    public abstract Comment map(CommentDto commentDto, Post post, User user);

    @Mapping(target ="postId",expression = "java(comment.getPost().getPostId())")
    @Mapping(target ="userId",expression = "java(comment.getUser().getUserId())")
    public abstract CommentDto mapToDto(Comment comment);
}
