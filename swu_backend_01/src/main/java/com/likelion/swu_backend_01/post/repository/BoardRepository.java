package com.likelion.swu_backend_01.post.repository;

import com.likelion.swu_backend_01.post.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
