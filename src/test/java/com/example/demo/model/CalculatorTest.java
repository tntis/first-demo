package com.example.demo.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {
    @Test
    void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(3,5);
       // System.out.println(result);
        Assertions.assertEquals(8,result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(8); // Result is equal to 8

        //AssertJ
        // 메소드 체이닝(Method Chaining) 방식
        // Junit 에 비해 가동석이 (훨씬) 좋아짐
        // 타입 체크도 가능하다.

        // 유닛 테스트 원칙 : FIRST

        // TDD(Test-driven development)

    }

    @Test
    void testMinus() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(3,1);
        Assertions.assertEquals(2,result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(2);
       // System.out.println("result = " + result);

    }

    @Test
    void testMultifly() {
        Calculator calculator = new Calculator();
        int result = calculator.multifly(3,4);

        // 그냥 콘솔 출력 : 눈으로 확인해야 함
        System.out.println(result);

        // jUnit
        Assertions.assertEquals(12,result);

        // AssertJ
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(12);

    }

    @Test
    void testdivide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(6,2);
        Assertions.assertEquals(3,result);
    }

    @Test
    void testdivide2() {
        // Given : test 를 위한 준비
        Calculator calculator = new Calculator();
        int x = 10;
        int y = 5;
        // when : 실제 test 대상 = divide() 메소드
        // Test Case (TC)
        int result = calculator.divide(x,y);

        // Then : 동작 확인
        // 생산성이 좋아짐(코드가 많아질 경우

        // OverLoading (파라미터 개수가 다르거나, 파라미터 차임이 달라야함)
        // 원시타입(Primitive) / 객체 타입 (Object)
        // overriding (매소드 재정의) -X

        Assertions.assertEquals(2, result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(2);

        //(테스트) 커버리지 : 내가 만둔 테스트 코드가 실행 코드를 얼마나 대응하고 있는징를 나타냄
        // 실행된 코두 중에 포함 여부 빨강 : test 가 안됬을 떄 Line Coverage 를 달성 하지 않을 경우
        // 주황 : coverage 룰 부분 만 달성한 경우
        // 초록 : test 에 포함되어 있을 때

        //coverage : Line, class, method, branch

    }
    @Disabled
    @Test
    void testdivideByZero() {
        // 0 으로 나눈 경우 hello.divice() 에 if 문이 없을 경우 에러없이 실행.

        Calculator calculator = new Calculator();
        int x = 10;
        int y = 0;

        // When
        // 람다식 (Lambda Expression) -> java8(1.8)
        // Java 8애서 추가된 거 중 대표적인 것 : 람다식 , Optional, Stream

        // JUnit
        Executable executable = () -> {
            calculator.divide(x, y);
        };
        // 한줄일 경우
        // Executable executable2 = () -> hello.divide(x, y);

        ThrowableAssert.ThrowingCallable throwingCallable = () -> { // AssertJ
            calculator.divide(x, y);
        };


        // Then : 동작 확인

        //JUnit
       Assertions.assertThrows(ArithmeticException.class, executable);
    /*   Assertions.assertThrows(ArithmeticException.class, () -. {
            hello.divide(x, y);
        });*/

        // AssertJ
        org.assertj.core.api.Assertions.assertThatThrownBy(
                throwingCallable).isInstanceOf(ArithmeticException.class);
    /*    org.assertj.core.api.Assertions.assertThatThrownBy(()->{
            hello.divide(x, y);
        }).isInstanceOf(ArithmeticException.class);
        */

    }
    // Disabled 사용하지 않을 경우 사용
    @Test
    void testdivideByZero_return0() {
        Calculator calculator = new Calculator();
        int x = 10;
        int y = 0;

        // When
       int result =  calculator.divide(x, y);

        // Then
        Assertions.assertEquals(0, result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(0);


    }

    @Test
    void testdivide_x0() {
        Calculator calculator = new Calculator();
        // x,y 가 0인경우 coverage 에서 if(y==0){}까지만 체크한다
        int x = 0;
        int y = 2;

       int result =  calculator.divide(x,y);

        Assertions.assertEquals(0,result);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(0);
    }

}
