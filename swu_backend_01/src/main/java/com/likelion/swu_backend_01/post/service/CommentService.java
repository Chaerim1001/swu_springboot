package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.domain.Board;
import com.likelion.swu_backend_01.post.domain.Comment;
import com.likelion.swu_backend_01.post.dto.CommentDto;
import com.likelion.swu_backend_01.post.repository.BoardRepository;
import com.likelion.swu_backend_01.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    /* CREATE */
    @Transactional
    public Long saveComment(Long id, CommentDto commentDto) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));

        commentDto.setBoard(board);

        Comment comment = commentDto.toEntity();
        commentRepository.save(comment);

        return commentDto.getId();
    }
    /* UPDATE */
    @Transactional
    public Long update(Long board_id, Long comment_id, CommentDto commentDto) {
        Board board = boardRepository.findById(board_id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. " + board_id));

        Comment comment = commentRepository.findById(comment_id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + comment_id));

        if(!board_id.equals(comment.getBoard().getId())){
            throw new IllegalArgumentException("게시글과 댓긂이 매칭되지 않습니다.");
        }

        comment.update(commentDto.getComment());
        return comment.getId();
    }

    @Transactional
    public void delete(Long board_id, Long comment_id) {
        Board board = boardRepository.findById(board_id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. " + board_id));

        Comment comment = commentRepository.findById(comment_id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + comment_id));

        if(!board_id.equals(comment.getBoard().getId())){
            throw new IllegalArgumentException("게시글과 댓긂이 매칭되지 않습니다.");
        }
        commentRepository.delete(comment);
    }
}
