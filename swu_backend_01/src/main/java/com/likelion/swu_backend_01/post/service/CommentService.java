package com.likelion.swu_backend_01.post.service;

import com.likelion.swu_backend_01.post.domain.Board;
import com.likelion.swu_backend_01.post.domain.Comment;
import com.likelion.swu_backend_01.post.dto.CommentRequestDto;
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
    public Long saveComment(Long id, CommentRequestDto commentRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));

        commentRequestDto.setBoard(board);

        Comment comment = commentRequestDto.toEntity();
        commentRepository.save(comment);

        return commentRequestDto.getId();
    }
    /* UPDATE */
    @Transactional
    public Long update(Long comment_id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + comment_id));

        comment.update(commentRequestDto.getComment());
        return comment.getId();
    }

    @Transactional
    public void delete(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + comment_id));

        commentRepository.delete(comment);
    }

}
