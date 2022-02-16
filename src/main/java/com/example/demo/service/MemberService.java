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

    private final MemberRepository repository;
    
    @Autowired // 생성자 주입
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member) {
        repository.save(member);
        return member.getId();
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMember(Long memberId){
        Optional<Member> result = repository.findById(memberId);
        return result.orElse(null);
    }

    //회원 멤버 서비스(test) 만들어오기
}
