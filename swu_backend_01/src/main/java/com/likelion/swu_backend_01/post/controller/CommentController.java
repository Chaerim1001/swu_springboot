package com.likelion.swu_backend_01.post.controller;

import com.likelion.swu_backend_01.post.dto.CommentRequestDto;
import com.likelion.swu_backend_01.post.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{id}")
    public String write(@PathVariable("id") Long id, CommentRequestDto commentRequestDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();

        commentRequestDto.setWriter(username);
        commentService.saveComment(id, commentRequestDto);
        return "redirect:/post/{id}";
    }

    @PutMapping({"/comment/{board_id}/{comment_id}"})
    @ResponseBody
    public Long update(@PathVariable("board_id") Long board_id, @PathVariable("comment_id") Long comment_id, CommentRequestDto commentRequestDto) {
        return commentService.update(board_id, comment_id, commentRequestDto);
    }

    @DeleteMapping({"/comment/{board_id}/{comment_id}"})
    public String delete(@PathVariable("board_id") Long board_id, @PathVariable("comment_id") Long comment_id) {
        commentService.delete(board_id, comment_id);
        System.out.println(board_id);
        return "redirect:/post/{board_id}";
    }
}
