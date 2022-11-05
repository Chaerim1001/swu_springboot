package com.likelion.swu_backend_01.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Recomment extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String writer;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public Recomment(Long id, String text, String writer, Comment comment){
        this.id=id;
        this.text=text;
        this.writer=writer;
        this.comment=comment;
    }

    public void update(String comment) {
        this.text = text;
    }
}
