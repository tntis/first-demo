package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Sptring Container : IoC Container, DI Container
// 스프링 빈(Bean) : 싱글톤 객체
// @Conponent
//  -> @Controller @Service @Repository
// -> @Configuration
// @Bean


@Service // @component
@Slf4j
public class MemberService {
    // 스프링 빈 주입
    //1. 생성자 주임 : 장점 - 빈생성 시점에 주힙 후 ,변경 불가능 
    //2, 세터 주입 : 단점 - public(공개) 메소드이기 때문에. 실행중에 호출 가능
        /*  final 사용 불가
        private  MemberRepository repository;
        @Autowired
        public void setRepository(MemberRepository repository) {
            this.repository = repository;
        }
        */

    // 3. 필드 주임 : 단점 - 스프링에서만 주입가능 (test 코드에서는 사용가능//@SpringBootTest
        // @Autowired private  MemberRepository repository;


    private final MemberRepository repository;
    
    @Autowired // 생성자가 하나일 경우 @Autowired 어노테이션 생랙가능
    public MemberService(MemberRepository repository) {

        this.repository = repository;
        System.out.println("repository = " + repository);
    }
    // 의존성 (Dependency)
    // 클래스 필드 또는 메소드 파라미터에는 상위타입을 사용하는게 좋다
    // 상위타입(슈퍼타입)을 지정하는게 좋다. 가장 좋은건 Interface가 좋다
    // <-> 하위타입(서브타입)

    // 상위타입에는 하위타입을 담을 수 있다

    // SOLID 원칙(객체 지향 설계)
    //    SRP  단일책임원칙
    //    OCP ( Open- Closed Pricipal)  개방-폐쇄 원칙 --> 확장에는 열려있고 수정에는 닫혀있다.
    //    LSP  리스코프 치환 원칙  --> 상위타입은 하위타입을 담을 수 있다.
    //    ISP  인터페이스분리우너칙
    //    DIP 의존관계역전원칙

    // 전자정부프레임워크 (JPA)
    // ORM(Object Relations Mapping,객체관계매칭)
    // -> 스프링부트 펴준 :  JPA (Java Persistence API)
    // -> JPA 스펙/ 명세/ 구격 -> JPA 수현체 : 하이버네이트(Hibernate)
    // -> 스프링 데이터 JPA



    public Long join(Member member) {
            checkDuplicateMemberName(member); // try catch 가없어도 join2 와 같은 로직으로 작동함
            repository.save(member);
            return member.getId();
    }
//안좋은 코드 // 에러 로그를 남길 경우,
    public Long join2(Member member) {
        try {
            checkDuplicateMemberName(member);
            repository.save(member);
            return member.getId();
        } catch (IllegalStateException e) {
//            return 0L;
            throw  e;
        }

    }

    private void checkDuplicateMemberName(Member member) {
        Optional<Member> result =  repository.findByName(member.getName());
        log.info("result : {} ", result);
        if (result.isPresent()) {
            // return 0L; 보다는
            throw  new IllegalStateException("중복된 이름이 있습니다.");
        }
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMember(Long memberId){
        Optional<Member> result = repository.findById(memberId);
        return result.orElse(null);
    }

// 부모 클래스는 자식 클래스의 메소드를 모른다 때문에 에러발생하는 이유
   public void removeMember(){
      //  repository.clearStore();
    }
}

//Error, Exception, RuntimeException