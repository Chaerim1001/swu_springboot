package com.likelion.swu_backend_01.post.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostUpdateDto {
    private String title;
    private String contents;
}