package com.likelion.swu_backend_01.post.dto;

import com.likelion.swu_backend_01.post.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String contents;

    private String writer;

    private List<Comment> comments;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;


    @Builder
    public BoardResponseDto(Long id, String title, String contents, String writer, LocalDateTime createdTime, LocalDateTime modifiedTime, List<Comment> comments){
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.writer=writer;
        this.comments=comments;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}
