package com.example.demo.config;

import com.example.demo.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import javax.persistence.EntityManager;
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
    public MemberRepository memberRepository(DataSource dataSource
    /* EntityManager em */) {
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);
    }



}

// 구현체 주입 방식
// 1. @Component로 지정된 구현체를 주입
// 2. @Bean 으로 지정된 메소드로 구현체 주입


// no qualifying bean of type
// 에러가 주입이 불가능한경우, 두개 이상인경우?



// IntelliJ 플러그인
// CodGlance2
// Grep Console
// SonaLint
// -> 정적분석 도구인 SonarQube를 연동해서 사용가능
// -> 정적분석 :  IntelliJ, SonarLint
// -> vs. 동적분석 : 유닛테스트, 성능테스트, 부하(스트레스)테스트...














