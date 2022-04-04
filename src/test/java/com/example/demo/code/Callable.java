package com.example.demo.code;


@FunctionalInterface // 함수형 인터페이스를 명시적으로 표시해준다
public interface Callable {

    void call();

    // 바디가 있는 메소드일 경우에는 사용가능 함
    // 1개 바디가 없는 메소드, 여러가의 바디가 있는 메소드 가능??

    
    // Java 1.8 변경사항 : default 메소드와 static 메소드 사용가능
    static void run() {

    }


}

// interface는 형용사도 가능하다 (명사로 표기함)