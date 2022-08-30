package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.domain.Post;
import com.likelion.swu_backend_01.post.repository.PostRepository;
import com.likelion.swu_backend_01.post.repository.dto.PostCreateDto;
import com.likelion.swu_backend_01.post.repository.dto.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostCreateDto postCreateDto){
        Post new_post = new Post(postCreateDto);
        return postRepository.save(new_post);
    }

    public Post findPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    @Transactional
    public Long updatePost(Long id, PostUpdateDto postUpdateDto){
        Post post = this.findPostById(id);
        return post.update(postUpdateDto);
    }

    @Transactional
    public Long deletePost(Long id){
        postRepository.deleteById(id);
        return id;
    }
}