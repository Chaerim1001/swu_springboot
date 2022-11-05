package com.likelion.swu_backend_01.post.repository;

import com.likelion.swu_backend_01.post.domain.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {}
