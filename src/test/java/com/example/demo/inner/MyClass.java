package com.example.demo.inner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClass {
    // 인스턴스 필드
    public String instanceField;
    
    // 정적 필드
    public static String staticField; // 클래스 마다 1개 존재

    // 인스턴스(객체) 메소드
    public void instanceMethod(){
        log.info(">>> instanceMethod");
    }

    // 정적(static) 메소드
    public static void staticMethod(){
        log.info(">>> staticMethod");
    }
    
    //이너(Inner) 클래스
    public class MyiInnerClass{
        public void call(){
            MyClass.this.instanceField = "a"; // 인스턴스 멤버
            MyClass.staticField ="q"; // 정적 멤버
        }
        
    }
    // 정적 (멤버) 클래스
    // 이너 클래스 xxx
    public static class MyStaticClass{
        public void call(){
//            MyClass.this.instanceField = "a"; // 인스턴스 멤버 -> 불가능
            MyClass.staticField = "w";
        }
    }
}

/*

 동일성(identity) : 참조값(갹채 주소)이 같다. == 비교 두 개의 객체가 완전히 같은 경우를 의미 (동일하다고 동등한것은 아니다,시점이 다를 수 있기 때문에)
 동등성(equality) : 내용이 같다 equals() 두 개의 객체가 같은 정보를 갖고 있는 경우를 의미

 int, long, char -> Primitive Type(기본 타입)
 = 주소가 없다

 Integer, Long, Char -> Wrapper Type(래퍼 타입)

 Reference Type
 = 클래스를 통해 생성한 객체


*/