package com.example.demo.facade;


public class Entrance {
    private String HO;

    public Entrance(String HO) {
        this.HO = HO;
    }


    public void enter(){
        System.out.println(HO + "를 입력하셧습니다.");
    }
    public void printPaper(){
        System.out.println("출입증이 나옵니다.");
    }

}
