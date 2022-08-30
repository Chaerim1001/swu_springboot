package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.domain.Post;
import com.likelion.swu_backend_01.post.repository.PostRepository;
import com.likelion.swu_backend_01.post.repository.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(PostCreateDto postCreateDto){
        Post new_post = new Post(postCreateDto);
        return postRepository.save(new_post);
    }

    public Post findPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }


}