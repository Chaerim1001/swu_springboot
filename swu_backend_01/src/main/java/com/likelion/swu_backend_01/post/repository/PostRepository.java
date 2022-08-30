package com.likelion.swu_backend_01.post.repository;

import com.likelion.swu_backend_01.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
