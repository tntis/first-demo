package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

// 좋은 코드, 좋은 설계 : 강한 응집도, 약한 결합도(Strongly Cohesion,)

@Slf4j
public class OvenTimer {

    private Timer timer;
    private Oven oven;

    public OvenTimer(Oven oven) {
        this.oven = oven;
    }

    public void on(int second) {
        log.info("타이머 ON");

        TimerTask timerTask = new OvenTimerTask(second);
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
        
    }

    public void off() {
        log.info("타이머 OFF");
        timer.cancel();
       //// oven.off();  // StackOverflowError
    }

    // 타이머 종료 신호 수싲 메소드 -> 0
    // 타이머 종료 처리 메소드 > x
    // 비동기식 프로그래밍할 때 필요한 방법(지금은 동기식(
    public void onTimerStopped(){
        log.info("stop");
        oven.off(); // 타이머 종료 처리
    }



    // 정적 멤버 클래스 (vs. 이너 클래스)
    //@Slf4j  is not supported on non-static nested classes.
    private class OvenTimerTask extends TimerTask {
        private int second;

        public OvenTimerTask( int second) {
            this.second = second;
        }

        @Override
        public void run() {
            log.info("타이머 : " + second--);
            if(second < 0){
               // ovenTimer.off();
                OvenTimer.this.onTimerStopped();
            }
        }
    }
}
// this : 메소드가 속한 객체 (this가 없는 메소드도 있다(static, 정적 메소드))
// oom -> OutOfMemoryError


// MSA(Micro-Service Architecture)