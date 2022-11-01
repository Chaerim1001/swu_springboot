package com.likelion.swu_backend_01.post.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


    @Builder
    public Comment(Long id, String comment, String writer, Board board){
        this.id=id;
        this.comment=comment;
        this.writer=writer;
        this.board=board;
    }
}
