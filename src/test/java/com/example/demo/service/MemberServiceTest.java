package com.example.demo.service;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    
    @Test
    void join() {
        Member member = new Member();
        

    }

    @Test
    void getAllMembers() {
    }

    @Test
    void getMember() {
    }
}