package com.example.demo.model;

public class Calculator {

    public int add(int x , int y){
        return x + y;
    }

    public int minus(int x,int y) {
        return x - y;
    }

    public int multifly(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
/*        if(y == 0) {
            return 0;
        }
        if (x == 0){
            return 0;
        }*/

        if (x == 0 || y == 0){
            return 0;
        }

        return x / y;
    }

//  psvm + tab 하면 자동완성됨
    // 메소드 로직 테스트 방법
//    public static vold main(String[] args){
//        Hello hello = new Hello();
//        int result = hello.add(3,5);
//        System.out.println(result);
//    }
}
