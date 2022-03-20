package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OvenSlideTable {

    public void on(){
        log.info("슬라이드테이블 ON");
    }

    public void off(){
        log.info("슬라이드테이블 OFF");
    }
}
