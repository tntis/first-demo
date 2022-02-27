package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;
// 인터페이스의 역할 : 규격, 명세, 스펙
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
    
    default void clearStore(){
        // 코드 
    }
    static void testStatic(){
        // 코드으
    }
    
}

// Java 1.8 에 추가된 것
// Optional, Stream, Lambda Expression(람다식)
// 인터페이스 : default, static 메소드 정의할 수 있다.(메소드 Body를 추가할수 있다.)