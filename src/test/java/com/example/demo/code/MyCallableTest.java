package com.example.demo.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
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

    @Test
    void runnable() {
        Runnable runnable = () -> System.out.println("running...");
        runnable.run();
    }

    @Test
    void supplier() {
        Supplier<String> supplier = () -> "supplier";
        String s = supplier.get();
        System.out.println("s = " + s);
    }

    @Test
    void consumer() {
        //Generic은 Wrapper 타입 또는 Rㄷference 타입만 가능
        Consumer<Integer> consumer1 = i -> System.out.println("integer1 = " + i);
        Consumer<Integer> consumer2 = i -> System.out.println("integer2 = " + i);


        consumer1.accept(9999);
        consumer2.accept(5555);

        //함수형 프로그래밍의 스타일.. Stream, optional, Webflux(비동기)
        consumer1.andThen(consumer2).accept(8888);
        consumer1.andThen(consumer2).accept(8888);

        // 종단(Terminated) 메소드
    }

    @Test
    void function() {
        Function<Integer, Boolean> function = i -> i > 0;
        Boolean result1 = function.apply(0);
        Boolean result2 = function.apply(23);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    @Test
    void function2() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        System.out.println("multiply.apply(3) = " + multiply.apply(3));
        System.out.println("add.apply(5) = " + add.apply(5));

        System.out.println("multiply.andThen(add).apply(4) = " + multiply.andThen(add).apply(4));   // 4*2 +3
        System.out.println("multiply.compose(add).apply(4) = " + multiply.compose(add).apply(4));  // 4+3 *2
    }

    @Test
    void optional() {
        // 정적 팩토리 메소드 패턴(디자인 패턴)
        String s = null;
      //  Optional<String> optS1 = Optional.of(s); // null 이면 에러가 남
        Optional<String> optS2 = Optional.ofNullable(s); // null 일수 도 있음 에러발생 ㄴ

        String s1 = optS2.orElse("Default");  // null 아니면 값을 표출, null 이면 orElse에 있는 값을 보여줌
        System.out.println("s1 = " + s1);
        
        Optional<Object> optS3 = Optional.empty();   // 만들어는졌지만 아무것도 담기지 않음


    }



}

// @ 객체 , $ 클래스

//andThen , 상위 super 하위(같은것도가능하며 상위타입만 가능),  하위 extends 상위