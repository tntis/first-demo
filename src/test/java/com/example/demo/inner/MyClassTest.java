package com.example.demo.inner;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
 class MyClassTest {
    @Test
    void test(){
        MyClass myclass = new MyClass();
        myclass.instanceField = "aaa";
        MyClass.staticField =  "qqq";

        System.out.println("myclass.instanceField = " + myclass.instanceField);
        System.out.println("myclass.staticField = " + myclass.staticField);

        MyClass myClass2 = new MyClass();
        myClass2.instanceField = "bbb";
        MyClass.staticField = "www";

        System.out.println("myClass2.instanceField = " + myClass2.instanceField);
        System.out.println("myClass2.staticField = " + myClass2.staticField);

        System.out.println("myclass.instanceField = " + myclass.instanceField);
        System.out.println("myclass.staticField = " + myclass.staticField);

        myclass.instanceMethod();
        MyClass.staticMethod();

    }

    @Test
    void testClass(){
        // 이너(인스턴스) 클래스 객체 생성
        MyClass.MyiInnerClass myiInnerClass1 = new MyClass().new MyiInnerClass();
        MyClass.MyiInnerClass myiInnerClass2 = new MyClass().new MyiInnerClass();
        log.info(">>> myiInnerClass: {}", myiInnerClass1.equals(myiInnerClass2));
        // new를 사용하여 각각 객체를 생성한 경우, 두 객체의 == 비교(참조값 비교)는 무조건 false이다.
        // 그래서 equals() 메소드로 변경하라고 IntelliJ에서 알려준다.
        // equals() 메소드를 통한 비교는 내용 비교이나, 해당 메소드를 오버라이드 해야 한다.


        // 정적  (멤버) 클래스 객체 생성
        MyClass.MyStaticClass myStaticClass1 = new MyClass.MyStaticClass();
        MyClass.MyStaticClass myStaticClass2 = new MyClass.MyStaticClass();
        log.info(">>> myStaticClass :{}", myStaticClass1.equals(myStaticClass2));
    }
}
