package com.example.demo.service;

import com.example.demo.model.Calculator;
import org.springframework.stereotype.Service;

@Service // @Component 포함되었음  // @Service 대신에 @Compoent 써도되용
// 서비스 기능을 수행한다는 논리적인 의미만 부여(현재)
// 객체변수명 : calculatorService
public class CalculatorService {
    public int add(int x, int y){
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        // 클래스와 객체의 차이
        // class : 붕어빵 틀
        // 객체 : 붕어빵 , 여러 개 만들 수 있다
        return calculator1.add(x,y); // 역할 위임(Delegate)
    }

    public int minus(int x, int y){
        Calculator calculator = new Calculator();
        return calculator.minus(x, y);

    }

}
