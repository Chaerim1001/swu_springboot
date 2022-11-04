package com.likelion.swu_backend_01.post.dto;

import com.likelion.swu_backend_01.post.domain.Board;
import com.likelion.swu_backend_01.post.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String comment;
    private String writer;
    private Board board;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Comment toEntity(){
        Comment build = Comment.builder()
                .id(id)
                .comment(comment)
                .writer(writer)
                .board(board)
                .build();
        return build;
    }

    @Builder
    public CommentDto(Long id, String comment, String writer, Board board, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id=id;
        this.comment=comment;
        this.writer=writer;
        this.board=board;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}

