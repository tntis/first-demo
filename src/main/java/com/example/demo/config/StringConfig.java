package com.example.demo.config;

import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 수동으로 객체 생성??
@Configuration //@Component와는 약간의 차이가 있다.
// 구성 (Configuration)
public class StringConfig {

    @Bean
    public MemberRepository memoryMemberRepository(DataSource dataSource) {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }



}

// 구현체 주입 방식
// 1. @Component로 지정된 구현체를 주입
// 2. @Bean 으로 지정된 메소드로 구현체 주입


// no qualifying bean of type
// 에러가 주입이 불가능한경우, 두개 이상인경우?