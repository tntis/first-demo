package com.example.demo.code;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;


class MyCallableTest {

    @Test
    void call_0() { // 람다변환의 예??
        IntBinaryOperator operator = new IntBinaryOperator() {
            @Override public int applyAsInt(int x, int y) {
                return Math.min(x, y);
            }
        };

        IntBinaryOperator operator2 = (x, y) -> Math.min(x, y);

        // 메소드 레퍼런스(참조)
        IntBinaryOperator operator3 = Math::min;

        // type : primitive type, weapper type, Reference type
        // generic (java1.5)
        Supplier<String> supplier = () -> "Hello";
        System.out.println("supplier.get() = " + supplier.get());

    }

    @Test
    void call_1() {
        System.out.println("MyCallableTest.call_1()");
        Callable myCallable = new MyCallable();
        myCallable.call();
        System.out.println(">>>this 2= " + this);
        System.out.println("myCallable = " + myCallable);
    }

    
    @Test
    void call_2() {
        System.out.println("MyCallableTest.call_2()");
        Callable myCallable = new Callable() { // 익명 (구현) 클래스
            @Override
            public void call() {
                System.out.println(">>> this 1 = " + this);  // MyCallableTest $1@602e0143 : MyCallableTest 클래스 안에 있는 $1 클래스 1개
            }
        };
        myCallable.call();
        System.out.println(">>>this 2= " + this);
        System.out.println("myCallable = " + myCallable);
    }

    @Test
    void call_3() {
        System.out.println("MyCallableTest.call_3()");
        // 람다식 = 함수형 프로그래밍 관점
        // 익명 구현 클래스와 유사한 객체이다.
        // 람다 : this가 익명 구현 클래스와 다르다.
        // 람다 캡쳐링 : 람다가 실행될 때, 메모리 동작
        // 람다 : 구현 대상 인터페이스의 메소드가 1개여야한다.
        Callable callable = () -> System.out.println(">>> this 1 = " + this);          //  내부적으로 보면 객체다
        callable.call();
        System.out.println(">>>this 2= " + this);
        System.out.println("callable = " + callable);
    }
}

// @ 객체 , $ 클래스

//andThen , 상위 super 하위(같은것도가능하며 상위타입만 가능),  하위 extends 상위