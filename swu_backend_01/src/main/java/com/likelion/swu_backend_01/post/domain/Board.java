package com.likelion.swu_backend_01.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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

    @Builder
    public Board(Long id, String title, String contents){
        this.id=id;
        this.title=title;
        this.contents=contents;
    }
}
