package com.likelion.swu_backend_01.post.controller;

import com.likelion.swu_backend_01.post.domain.Post;
import com.likelion.swu_backend_01.post.repository.dto.PostCreateDto;
import com.likelion.swu_backend_01.post.repository.dto.PostUpdateDto;
import com.likelion.swu_backend_01.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody PostCreateDto postCreateDto) {
       return this.postService.createPost(postCreateDto);
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id){
        return this.postService.findPostById(id);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        return this.postService.updatePost(id, postUpdateDto);
    }
}

