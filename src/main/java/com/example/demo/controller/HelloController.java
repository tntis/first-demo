package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Calculator;

//  계층(Layer)/기능 관점 :  @Controller , @Service, @Repository

@RestController
// @Controller + @ResponseBody 가 합쳐진    // @Controller (@Component)
// @Component 어노테이션이 붙은 모든 클래스 객체를 스프링 부트가 생성함
// 이 때, 객체를 1개만 생성한다(싱클톤 객체 -> 빈(Bean) // 스프링이 어딘가 @Component 객체를 1개씩 만둘어서 어딘가에 저장하고 있다.
// -> where? IoC(Inversion of Control: 제어 역전) 컨테이너 or DI(Dependency Injection:의존 주입) 컨테이너 or 스프링 컨테이너

// @Component 어노테이션은 컴포넌트 스캔 대상이다.

// helloController
public class HelloController {
    
    //CalculatorService calculatorService =  new CalculatorService();

    //스프링 의존성 주입 방법
    // 1. 필드 인젝션
    // 2. 세터 인젝션
    // final 을 선언하지 않는다

    // 3. 생성자 인젝션
    
   // 클래스(객체) 멤버 = 필드 + 메서드
   // @Autowired // 컨테이너에 생성된 객체를 실행(런타임) 시점에 주입(Injection)함
    // 1. 필드 인젝션 (미추천)
   private CalculatorService calculatorService; //  필드
    // HelloController 는 CalculatorService에 의존한다. (CalculatorService가 없으면 안됨)
    
    // Setter 메소드 인젝션  (Getter 도 있음)
//      @Autowired  // 2. 세터 인젝션
//    public void setCalculatorService(CalculatorService cService) {
//        this.calculatorService = cService;
//    }

       @Autowired // 3. 생성자 인젝션(주입) -> 가장 좋음
    public HelloController(CalculatorService service) {
           this.calculatorService = service;
     }



    // @Autowired  // 런타임 오류 발생
    // private Calculator calculator55;

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!!";
    }

    //HTTP status Code
    // 4xx - 클라이언트 측 오류
    // 400 - Bad REquest
    // 404 -
    // 5xx - 서버 측(Server Side) 오류
    //?x=1&y=4 쿼리 스트링
    @GetMapping("/calc/add")
    public int add(@RequestParam int x, @RequestParam int y) {
        System.out.println("this = " + this); // this -> 자신의 객체를 가르침, 항상 존재
        System.out.println("calculatorService = " + calculatorService);
        return calculatorService.add(x,y);
    }

    // 모든 메소드에는 this 변수가 있다.
    // 이 this는 자신의 메소드가 속한 객체를 참조한다.
    
    @GetMapping("/calc/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        System.out.println("this = " + this);
        System.out.println("calculatorService = " + calculatorService);
        return calculatorService.minus(x,y);
    }

    // 메소드 로직 테스트 방법 1)
    @GetMapping("/add")
    public int testAdd(){
        Calculator calculator1 = new Calculator();
        return calculator1.add(3,4);

    }


    @GetMapping("/add2")
    public int testAdd2(){
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        // 클래스와 객체의 차이
        // class : 붕어빵 틀
        // 객체 : 붕어빵 , 여러 개 만들 수 있다
        return calculator1.add(3,4); // 역할 위임(Delegate)

    }

}

    // 템플릿 엔진 : View 화면단을 말함
    // JSP, Thymeleaf, Velocity

    // Controller 의 역할
    // -> 외부 API 규격을 정의 (규격 =  URL + 파라미터 + 응답값)
    //  -> URL = URi + URN
    // -> 자신의 역할 외으ㅔ 다른 일은 다른 놈 한테 시킨다

    // 오류 종류
    // 1. 컴파일(빌드) 오류 -> 컴파일 시 오류 발생 / 오류는 이 떄 발견하는게 좋음
    // 2. 런타임(실행) 오류 -> 실행 초기에 오류가 나거나, 실행 중에 오류가 남
/*
     HTTP Method : 요청
     GET : 조회(R)
     POST : 저장(C), (복잡한 조건의) 조회, 기타 등등
     PUT : 전체수정(U)
     PATCH : 부분수정(U)
     DELETE : 삭제(D)
     -> RESTful API 설계를 해보면, 더 잘 알게 된다.
*/
    /*
    GET 파라미터
    POST 파라미터
    POST 바디
    -> 형식 : 파라미터





    http 프로토콜 규격
    **/
