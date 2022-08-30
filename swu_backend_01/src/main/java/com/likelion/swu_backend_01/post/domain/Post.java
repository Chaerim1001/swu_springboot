package com.likelion.swu_backend_01.post.domain;

import com.likelion.swu_backend_01.post.repository.dto.PostCreateDto;
import com.likelion.swu_backend_01.post.repository.dto.PostUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Post (PostCreateDto postCreateDto){
        this.title = postCreateDto.getTitle();
        this.contents = postCreateDto.getContents();
    }

    public Long update (PostUpdateDto postUpdateDto){
        this.title = postUpdateDto.getTitle();
        this.contents = postUpdateDto.getContents();
        return this.getId();
    }
}