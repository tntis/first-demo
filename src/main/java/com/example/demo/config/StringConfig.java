package com.example.demo.config;

import com.example.demo.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 스프링 Bean 생성
// 1. @Component로 지정된 구현체 주입
//   -> @Controller, @Serivce, @Repository
//   -> @Configuration
// 2. @Bean으로 지정된 메소드로 구현체 주입


// 수동으로 객체 생성??
@Configuration //@Component와는 약간의 차이가 있다.
// 구성 (Configuration)
public class StringConfig {

   // @Bean
    public MemberRepository memoryMemberRepository(/*DataSource dataSource
    */ EntityManager em) {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }



}

// 구현체 주입 방식
// 1. @Component로 지정된 구현체를 주입
// 2. @Bean 으로 지정된 메소드로 구현체 주입


// no qualifying bean of type
// 에러가 주입이 불가능한경우, 두개 이상인경우?