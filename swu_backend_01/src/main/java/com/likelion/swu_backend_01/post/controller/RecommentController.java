package com.likelion.swu_backend_01.post.controller;

import com.likelion.swu_backend_01.post.dto.RecommentDto;
import com.likelion.swu_backend_01.post.service.RecommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RecommentController {
    private final RecommentService recommentService;

    @PostMapping("/recomment/{board_id}/{comment_id}")
    public String write(@PathVariable("board_id") Long board_id, @PathVariable("comment_id") Long comment_id, RecommentDto recommentDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();

        recommentDto.setWriter(username);
        recommentService.saveRecomment(board_id, comment_id, recommentDto);
        return "redirect:/post/{board_id}";
    }
}
