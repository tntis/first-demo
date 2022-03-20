package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

// 좋은 코드, 좋은 설계 : 강한 응집도, 약한 결합도(Strongly Cohesion,)

@Slf4j
public class OvenTimer {

    private Timer timer;

    public void on(int second) {
        log.info("타이머 ON");

        TimerTask timerTask = new OvenTimerTask(this,second);
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
        
    }

    public void off() {
        log.info("타이머 OFF");
        timer.cancel();
    }

    
    // 멤버 클래스(이너 클래스)
    @Slf4j
    public static class OvenTimerTask extends TimerTask {
        private final OvenTimer ovenTimer;
        private Oven oven;
        private int second;

        public OvenTimerTask(OvenTimer ovenTimer, int second) {
            this.ovenTimer = ovenTimer;
            this.second = second;
        }

        @Override
        public void run() {
            log.info("타이머 : " + second--);
            if(second < 0){
                //ovenTimer.off();
                oven.off();
            }
        }
    }
}
// this : 메소드가 속한 객체 (this가 없는 메소드도 있다(static, 정적 메소드))
