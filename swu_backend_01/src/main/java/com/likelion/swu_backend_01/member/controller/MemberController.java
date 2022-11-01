package com.likelion.swu_backend_01.member.controller;

import com.likelion.swu_backend_01.member.dto.MemberDto;
import com.likelion.swu_backend_01.member.service.MemberService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("user/signup")
    public String signUpForm() {
        return "users/signup.html";
    }

    @PostMapping("user/signup")
    public String signUp(@Valid MemberDto memberDto, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("MemberDto", memberDto);

            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for(String key: validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }
            return "users/signup.html";
        }
        memberService.checkEmailDuplication(memberDto); // 이메일 중복 검사

        memberService.joinUser(memberDto);
        return "redirect:/";
    }

    @GetMapping("user/login")
    public String member(){
        return "users/login.html";
    }

    @GetMapping("/admin")
    public String adminPage(Model model){
        List<MemberDto> memberList = memberService.getMemberList();
        model.addAttribute("memberList", memberList);
        return  "users/admin.html";
    }

}
