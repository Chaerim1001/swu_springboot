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

    @PostMapping("/post/comment/{id}")
    public String write(@PathVariable Long id, CommentRequestDto commentRequestDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();

        commentRequestDto.setWriter(username);
        commentService.saveComment(id, commentRequestDto);
        return "redirect:/post/{id}";
    }

    @PutMapping({"/post/comment/{comment_id}"})
    @ResponseBody
    public Long update(@PathVariable Long comment_id, CommentRequestDto commentRequestDto) {
        return commentService.update(comment_id, commentRequestDto);
    }

    @DeleteMapping({"post/comment/{comment_id}"})
    public void delete(@PathVariable Long comment_id) {
        commentService.delete(comment_id);
    }
}
