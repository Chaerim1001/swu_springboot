package com.likelion.swu_backend_01.post.repository;

import com.likelion.swu_backend_01.post.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}

