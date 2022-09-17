package com.likelion.swu_backend_01.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("name", "Likelion 10th Chaeyeon");
        return "hello";
    }
}
