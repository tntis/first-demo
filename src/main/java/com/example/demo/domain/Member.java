package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

// OOP(Object Oriented Programing: 객체 지향 개벌ㅋ)
// 도메인(domain) : 비즈니스 도메인, 업무 영역
// 클래스(객체) = 필드 (속성에 저장) + 메서드(행위)
@Getter @Setter
public class Member {

    // 필드(멤버번수)
    // 필드 vs 프로퍼티(속성)
    private Long id;
    private String name;

    public Member(){};
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 오류
    // 1. 빌드타임 오류
    //2 런(실행) 타임 오류

    // 빌드타임에 동작

  //  @JsonInclude(JsonInclude.Include.NON_NULL) 확인하기기기기ㅣㄱ
    
}
