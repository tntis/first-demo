package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Sptring Container : IoC Container, DI Container
// 스프링 빈(Bean) : 싱글톤 객체
// @Conponent
// @Controller @Service @Repository
// @Bean


@Service // @component
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
    }
    // 의존성 (Dependency)
    // 클래스 필드 또는 메소드 파라미터에는 상위타입을 사용하는게 좋다
    // 상위타입(슈퍼타입)을 지정하는게 좋다. 가장 좋은건 Interface가 좋다
    // <-> 하위타입(서브타입)

    // 상위타입에는 하위타입을 담을 수 있다

    // SOLID 원칙(객체 지향 설계)
    // 중 L다한


    public Long join(Member member) {
            checkDuplicateMemberName(member); // try catch 가없어도 join2 와 같은 로직으로 작동함
            repository.save(member);
            return member.getId();
    }
//안좋은 코드
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


    public void removeMember(){
        repository.clearStore();
    }
}

//Error, Exception, RuntimeException