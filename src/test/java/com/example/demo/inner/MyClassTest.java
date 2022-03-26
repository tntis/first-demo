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

        // 정적  (멤버) 클래스 객체 생성
        MyClass.MyStaticClass myStaticClass1 = new MyClass.MyStaticClass();
        MyClass.MyStaticClass myStaticClass2 = new MyClass.MyStaticClass();
        log.info(">>> myStaticClass :{}", myStaticClass1.equals(myStaticClass2));
    }
}
