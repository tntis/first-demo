package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    void save(){
        //Given
        Member member = new Member();
        member.setName("한수빈");

        //When
        Member saveMember = repository.save(member);

        Optional<Member> optionalMember = repository.findById(member.getId());
        Member savedMember = optionalMember.get();
        // optionalMember.orElse(null); 값이 있으면 값을 보내고 없으면 other에 쓰면됨


        // Then
       assertThat(saveMember.getId()).isEqualTo(1);
       assertThat(saveMember).isEqualTo(member); // == 비교
        //
        System.out.println("member = " + member);
        System.out.println("saveMember = " + saveMember);

        assertThat(savedMember).isEqualTo(member);

        Member member2 =  repository.findById2(1L);

    }

    @Test
    void findByName() {

    }

    @Test

}