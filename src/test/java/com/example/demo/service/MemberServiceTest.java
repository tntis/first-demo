package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
class MemberServiceTest {
    /*
     //@SpringBootTest 사용시
    @Autowired
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        memberService.removeMember();
     */

    MemberService memberService;
    MemberRepository memberRepository;
    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberService.removeMember();
    }



    @Test
    void join_정상() {
        //Given
        Member member = new Member();
        member.setName("수빈");

        // When
        Long memberId =  memberService.join(member);

        //Then
        assertThat(memberId).isEqualTo(1);
        assertThat(memberId).isEqualTo(member.getId());
        System.out.println("memberId = " + memberId);
    }

    @Test
    void join_Excetpion() {
        //Given
        Member member = new Member();
        member.setName("수빈");

        // When
        Long memberId =  memberService.join(member);

        //Then
        assertThat(memberId).isEqualTo(1);
        assertThat(memberId).isEqualTo(member.getId());
        System.out.println("memberId = " + memberId);
    }


    @Test
    void getAllMembers() {
        //Given
        Member member = new Member();
        member.setName("수빈일");
        Member member2 = new Member();
        member2.setName("수빈이");
        memberService.join(member);
        memberService.join(member2);

        // When
       List<Member> allMembers =  memberService.getAllMembers();

        //Then
       assertThat(allMembers.size()).isEqualTo(2);
        System.out.println("allMembers.size() = " + allMembers.size());

    }

    @Test
    void getAllMembers_NoMembers() {
        //Given

        // When
        List<Member> allMembers =  memberService.getAllMembers();

        //Then
        assertThat(allMembers).isEmpty();
    }

    @Test // 물어보기이이이이이이 // TODO
    void getMember() {
        //Given
        Member member = new Member();
        member.setName("수빈일");
        Member member2 = new Member();
        member2.setName("수빈이");
        memberService.join(member);
        memberService.join(member2);

        // When
        System.out.println("member.getId() = " + member.getId());
        System.out.println("member2.getId() = " + member2.getId());
       Member resultMember =  memberService.getMember(1L);
        System.out.println("resultMember.getId() = " + resultMember.getId());
        //memberService.getMember(member.getId()); // 에러가 발생할 가능성이 있기때문에 이런 방식으로 하는것이 더  좋음

       //Then
        assertThat(resultMember.getId()).isEqualTo(member.getId());

        assertThat(resultMember).isEqualTo(member);
    }
}

//@SpringBootTest  가없으면 Authwired 가 실행이 안되어 에러 발생 new 객제를 생성해애함