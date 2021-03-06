package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
//import com.sun.javadoc.MemberDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/*
* Controller에 데이터를 받아보자
*  - @RequestParam
*  - @PathVariable
*  - @RequestBody
*  - @ModelAttribute
* */
/*

    @Slf4j   -> Simple Logging Facade for Java
    퍼사드 패턴..
    @Slf4j : 명세, 스펙, 규격, 인터페이스
    -> 구현체 : log4j, log4j2, logback(스프링부트 디폴트)
 */

@Slf4j
@RestController
@RequestMapping("/demo")
public class MemberController {

    @GetMapping("/path-variable/{name}/{email}")
    public String pathVariable(@PathVariable String name, @PathVariable String email ) {
        // System.out vs. log.info() -> 찾아보깅~!      log.info(3개이상부터는 Array 로만들기 떄문에 너무 많은 정보를 담는것을 안좋음)
        // stdout, stderr
        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK1";
    }

    @GetMapping("/path-variable2/{name}")
    public String pathVariabl2e(@PathVariable String name) {
        log.info("name : {}", name);
        return "OK1";
    }


    @GetMapping("/servlet-request")
    public String servletRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK2";
    }


    @GetMapping("/request-param")
    public String requestParams(
            @RequestParam String name, // name 같을때 name 생략가능
            // @RequestParam(name(value)로 써도된다  ="name")  String name,
            @RequestParam( required = false, defaultValue = "deault@gmail.com") String email
            // defaultValue 있을 경우 required 가 있을 필요가 없다.
    ) {
        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK3";
    }

    @GetMapping("/model-attribute")
    public String modelAttribute(
        @RequestParam String name2 , // Primitive Type, Wrqpper Type -> @RequestParam
        @ModelAttribute MemberDto memberDto // Referemce Type -> @ModelAttribute
        //  @ModelAttribute  생략가능함
        // 기본생성자 객체 생성 -> Setter 로 값 할당(변수명 기준)
        // toString
    ) {
    /*
        MemberDto dto = new MemberDto();
        dto.setName(name);
        dto.setEmail(email);
        memberDto = dto;
    */
        log.info("memberdto : {} ", memberDto);
        return "OK4";
    }

    @PostMapping("/request-param")
    public String requestParam2(
            @RequestParam String name,
            @RequestParam String email
    ) {
        log.info("name : {} ", name);
        log.info("email : {} ", email);
        return "OK6";
    }

    @PostMapping("/request-body/string")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyString(
            @RequestBody String body
    ) {
        log.info("body : {} ", body);
        return "OK5";
    }

    @PostMapping("/request-body/object")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyObject(
            @RequestBody MemberDto memberDto
    ) {
        log.info("memberdto : {} ", memberDto);
        return "OK6";
    }

    @PostMapping("/request-body/parameter")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyParameter(
            @ModelAttribute MemberDto memberDto
    ) {
        log.info("memberdto : {} ", memberDto);
        return "OK7";
    }



}
/*
String name // Primitive Type, Wrqpper Type -> @RequestParam
MemberDto //

 */

