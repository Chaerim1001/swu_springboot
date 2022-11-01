package com.likelion.swu_backend_01.post.controller;

import com.likelion.swu_backend_01.post.dto.CommentRequestDto;
import com.likelion.swu_backend_01.post.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
}
