package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*import  javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/

// OOP(Object Oriented Programing: 객체 지향 개벌ㅋ)
// 도메인(domain) : 비즈니스 도메인, 업무 영역
// 클래스(객체) = 필드 (속성에 저장) + 메서드(행위)



//JAP(Java Parsistence API)
// 스프링 표준 ORM(Object-Relational Mapping) -> 객체-관계 매핑
// -> RDB를 객체 지향적으로 사용하기 위한 방안
// 스프링 표준 ORM -> JPA -> 명세,규격, 스펙
// -> 구현체가 필요히다 : Hibernate, EclipseLink ...


@Entity // @Id 필수 선언, 기본 생성자(파라미터가 없는 생성자)가 있어야 함
@Getter @Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
public class Member {

    // 필드(멤버번수)
    //  @JsonInclude(JsonInclude.Include.NON_NULL)
    // 필드 vs 프로퍼티(속성)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 증복 라이브러리에 의해 Getter, Setter 메소드 빌드타임에 자동생성



    public Member( String name) {
        this.name = name;
    }


    
}



// 오류
// 1. 빌드타임 오류
//2 런(실행) 타임 오류

// 빌드타임에 동작


//  @JsonInclude(JsonInclude.Include.NON_NULL) 확인하기기기기ㅣㄱ