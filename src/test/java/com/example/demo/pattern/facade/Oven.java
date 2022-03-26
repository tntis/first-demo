package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Oven {

   private final OvenMagnetron magnetron;
   private final OvenSlideTable slideTable;
   // private final OvenTurnTable turnTable;
   private final OvenTimer timer;

   public Oven(){
       magnetron = new OvenMagnetron();
       slideTable = new OvenSlideTable();
//       turnTable = new OvenTurnTable();
       timer = new OvenTimer(this); 
   }

   public void on(int timerCount){
       magnetron.on();
       slideTable.on();
//       turnTable.start();
       timer.on(timerCount);
   }
   public void off(){
       timer.off();
       slideTable.off();
//       turnTable.stop();
       magnetron.off();

   }

}
