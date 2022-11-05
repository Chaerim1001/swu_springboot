package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.domain.Board;
import com.likelion.swu_backend_01.post.domain.Comment;
import com.likelion.swu_backend_01.post.domain.Recomment;
import com.likelion.swu_backend_01.post.dto.CommentDto;
import com.likelion.swu_backend_01.post.dto.RecommentDto;
import com.likelion.swu_backend_01.post.repository.BoardRepository;
import com.likelion.swu_backend_01.post.repository.CommentRepository;
import com.likelion.swu_backend_01.post.repository.RecommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RecommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;

    @Transactional
    public Long saveRecomment(Long board_id, Long comment_id, RecommentDto recommentDto) {

        validateBoardId(board_id);
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() ->
                new IllegalArgumentException("대댓글 쓰기 실패: 해당 댓글이 존재하지 않습니다." + comment_id));

        recommentDto.setComment(comment);

        Recomment recomment = recommentDto.toEntity();
        recommentRepository.save(recomment);

        return recommentDto.getId();
    }

    public void validateBoardId(Long board_id){
        Board board = boardRepository.findById(board_id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + board_id));
    }


}
