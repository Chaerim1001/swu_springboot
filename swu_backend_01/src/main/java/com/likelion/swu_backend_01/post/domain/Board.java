package com.likelion.swu_backend_01.post.domain;

import com.likelion.swu_backend_01.post.dto.BoardRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 정렬
    private List<Comment> comments;

    @Builder
    public Board(Long id, String title, String contents, String writer){
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.writer=writer;
    }

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }
}
