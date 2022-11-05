package com.likelion.swu_backend_01.post.dto;

import com.likelion.swu_backend_01.post.domain.Comment;
import com.likelion.swu_backend_01.post.domain.Recomment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommentDto {
    private Long id;
    private String text;
    private String writer;
    private Comment comment;

    public Recomment toEntity(){
        Recomment build = Recomment.builder()
                .id(id)
                .text(text)
                .writer(writer)
                .comment(comment)
                .build();
        return build;
    }

    @Builder
    public RecommentDto(Long id, String text, String writer, Comment comment){
        this.id=id;
        this.text=text;
        this.writer=writer;
        this.comment=comment;
    }
}
