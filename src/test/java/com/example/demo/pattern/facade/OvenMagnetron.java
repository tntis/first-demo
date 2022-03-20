package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 스프링 부트 기본 Slf4j 구현체 -> Logback
public class OvenMagnetron {

    public void on(){
        log.info("마이크로파 ON");
    }

    public void off(){
        log.info("마이크로파 OFF");
    }
}
