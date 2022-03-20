package com.example.demo.pattern.facade;

public class OvenUser {
    public static void main(String[] args) throws InterruptedException {
//        OvenMagnetron magnetron = new OvenMagnetron();
//        // OvenTurnTable turnTable = new OvenTurnTable();
//        OvenSlideTable slideTable = new OvenSlideTable();
//        OvenTimer timer = new OvenTimer();
//
//        // 전자레인지 동작시작
//        magnetron.on();
//        slideTable.on();
//        timer.on(5);

         Oven oven = new Oven();
         oven.on(4);

         Thread.sleep(3000);

        // oven.off();
//
            // 중간취소
//        magnetron.off();
//        slideTable.off();
//        timer.off();
    }
}
