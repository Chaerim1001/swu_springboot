package com.likelion.swu_backend_01.post.repository;

import com.likelion.swu_backend_01.post.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyword);
    List<Board> findByWriterContaining(String keyword);
}
