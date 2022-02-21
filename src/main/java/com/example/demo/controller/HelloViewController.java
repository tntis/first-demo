package com.example.demo.controller;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloViewController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data","한수빈");
        return "Hello";
        // ViewResolver 객체가 동작
        // 경로는 default 정해져 있음(변경가능)
    }

    @GetMapping("/hello2")
    @ResponseBody // 리턴값을 그대로 표현해줌
    public Member hello2(Model model){
        model.addAttribute("data","수빈");
        return new Member(1L,"한빈");
        // HttpMessageConverter 객체가 동작

        //return "hello";
    }
}

//