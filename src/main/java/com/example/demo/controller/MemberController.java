package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.sun.javadoc.MemberDoc;
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
public class MemberController {

    @GetMapping("/demo/path-variable/{name}/{email}")
    public String pathVariable(@PathVariable String name, @PathVariable String email ) {
        // System.out vs. log.info() -> 찾아보깅~!      log.info(3개이상부터는 Array 로만들기 떄문에 너무 많은 정보를 담는것을 안좋음)
        // stdout, stderr
        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK1";
    }

    @GetMapping("/demo/path-variable2/{name}")
    public String pathVariabl2e(@PathVariable String name) {
        log.info("name : {}", name);
        return "OK1";
    }


    @GetMapping("/demo/servlet-request")
    public String servletRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK2";
    }


    @GetMapping("/demo/request-param")
    public String requestParams(
            @RequestParam String name,
            @RequestParam( required = false, defaultValue = "deault@gmail.com") String email
            // defaultValue 있을 경우 required 가 있을 필요가 없다.
    ) {
        log.info("name : {}", name);
        log.info("email : {}", email);
        return "OK3";
    }

    @GetMapping("/demo/model-attribute")
    public String modelAttribute(
        @ModelAttribute MemberDto memberDto
        // 기본생성자 객체 생성 -> Setter 로 값 할당(변수명 기준)
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

    @PostMapping("/demo/request-body/string")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyString(
            @RequestBody String body
    ) {
        log.info("body : {} ", body);
        return "OK5";
    }

    @PostMapping("/demo/request-body/object")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyObject(
            @RequestBody MemberDto memberDto
    ) {
        log.info("memberdto : {} ", memberDto);
        return "OK6";
    }

    @PostMapping("/demo/request-body/parameter")
    //@RequestMapping(value = "/demo/request-body/string", method = RequestMethod.POST)
    public String requestBodyParameter(
            @ModelAttribute MemberDto memberDto
    ) {
        log.info("memberdto : {} ", memberDto);
        return "OK7";
    }



}


