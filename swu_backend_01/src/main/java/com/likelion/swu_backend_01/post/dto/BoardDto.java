package com.likelion.swu_backend_01.post.dto;

import com.likelion.swu_backend_01.post.domain.Board;
import lombok.Builder;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BoardDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String contents, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}
