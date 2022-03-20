package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OvenTurnTable {

    public void start(){
        log.info("턴테이블 ON");
    }

    public void stop(){
        log.info("턴테이블 OFF");
    }
}
