package com.example.demo.facade;

public class Client {
    public static void main(String[] args){
        FacadeZone zone = new FacadeZone("333");
        zone.open();
    }
}



/*
     A, B,(C1,C2) D
OCP 의존성을 최소화


 */
