package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
//@Rollback(false) // true 가 default
class MemberServiceTest {
    /*
     //@SpringBootTest 사용시
    @Autowired
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        memberService.removeMember();
     */

    @Autowired
    MemberService memberService;
    
   // MemberRepository memberRepository;
    
    @BeforeEach
    void beforeEach() {
       // memberRepository = new MemoryMemberRepository();
       // memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        //memberService.removeMember();
    }

    //@Test
    void testDI(){
        System.out.println("==== memberService = " + memberService);
    }
        
        
    

    @Test // 정상일떄
    void join() {
        //Given
        Member member = new Member();
        member.setName("수빈4");

        // When
        Long memberId =  memberService.join(member);

        //Then

        assertThat(memberId).isEqualTo(member.getId());
        System.out.println("memberId = " + memberId);
    }

    @Test // 중복가입일 경우
    @Rollback(false)
    void join_Excetpion() {
        //Given
        Member member = new Member();
        member.setName("수빈");
        Member member2 = new Member();
        member2.setName("수빈");
        memberService.join(member);

        // When
        //Then
        // assertThatThrownBy(()->memberService.join(member2)).isInstanceOf(IllegalStateException.class); 

        //when
        ThrowableAssert.ThrowingCallable callable = () -> memberService.join(member2);
        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalStateException.class); // 에러는 정확한 에러를 명시해주는 것이 좋다
        // 같은에러를 발생하나 메세지가 다른경우 hasMassage()를 추가
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

    @Test // 물어보기이이이이이이
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
       Member resultMember =  memberService.getMember(member.getId());
        System.out.println("resultMember.getId() = " + resultMember.getId());
        //memberService.getMember(member.getId()); // 에러가 발생할 가능성이 있기때문에 이런 방식으로 하는것이 더  좋음

       //Then
        assertThat(resultMember.getId()).isEqualTo(member.getId());


    }

    //@Test
    void testString(){
        String str1 =  new String("abced");
        String str2 =  new String("abced");
        String str3 =  "abced";    // 스트링 리터럴(Literal)
        String str4 =  "abced";

        // isEqualTo == 비교
        assertThat(str1).isEqualTo(str2);

        //isSameAs 참조값 비교
        assertThat(str1).isNotSameAs(str3);
        assertThat(str3).isSameAs(str4);
       
        // 성능
        // String vs. StringBuilder vs. StringBuffer
        // 스트링 변경시에는 StringBuffer 가 좋다
    }

}

//@SpringBootTest  가없으면 Authwired 가 실행이 안되어 에러 발생 new 객제를 생성해애함