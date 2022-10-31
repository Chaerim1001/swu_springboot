package com.likelion.swu_backend_01.post.domain;

import com.likelion.swu_backend_01.post.dto.BoardDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length= 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String writer;

    @Builder
    public Board(Long id, String title, String contents, String writer){
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.writer=writer;
    }

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
    }
}
