package com.example.demo.config;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 수동으로 객체 생성??
@Configuration //@Component와는 약간의 차이가 있다.
// 구성 (Configuration)
public class StringConfig {

    @Bean
    public MemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }



}
