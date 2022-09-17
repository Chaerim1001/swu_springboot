package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.dto.BoardDto;
import com.likelion.swu_backend_01.post.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}

