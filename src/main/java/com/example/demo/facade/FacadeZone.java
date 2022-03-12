package com.example.demo.facade;

public class FacadeZone {

    private String HO;

    public FacadeZone(String HO) {
        this.HO = HO;
    }

    public void open(){
        Entrance entrance = new Entrance(HO);
        Monitor monitor = new Monitor();
        Door door = new Door();

        monitor.Turn_on();
        entrance.enter();
        entrance.printPaper();
        door.open();
        monitor.Turn_off();
        door.close();
    }
}
