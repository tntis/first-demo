package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @BeforeEach // test 진행 전에 실행
    void beforeEach(){
        repository.claerStore();
    }

    // @AfterEach //test 진행 후에 실행

    @Test
    void save(){
        repository.claerStore(); // TDD

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
        //Given
        Member member = new Member();
        member.setName("수빈");

        //When
       Member saveMember = repository.save(member);
       Optional<Member> optionalMember2 =  repository.findByName(member.getName());
        Member member2 = optionalMember2.get();
        //Then
        assertThat(member2).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //Given
        Member member = new Member();
        member.setName("일등이");
        repository.save(member);
        Member member2 = new Member();
        member2.setName("이등이");
        repository.save(member2);
        //When

        List<Member> list = repository.findAll();
        //Then
        System.out.println("list.get(0).getName() = " + list.get(0).getName());
        System.out.println("list.get(1) = " + list.get(1).getName());
        assertThat(list.get(0)).isEqualTo(member);

    }

    @Test
    @DisplayName("전체조회")  // void 잔체조회(){} 로 도 가능
    void findAll2(){
        //Given
        Member member1 = new Member();
        member1.setName("일등이");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("이등이");
        repository.save(member2);
        //When
        List<Member> list = repository.findAll();

        //Then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo(member2);
    }

    @Test
    void findByName2() {
        //Given
        Member member1 = new Member();
        member1.setName("일등이");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("이등이");
        repository.save(member2);

        //When
        Optional<Member> optionalMember2 =  repository.findByName("이등이");
       
        //Then
        assertThat(optionalMember2).isPresent();

        // 조회할 값이 있으면 넘어가고 없으면 null을 리턴한다.
        Member member = optionalMember2.orElse(null);

        Member resultMember = optionalMember2.get();
        assertThat(resultMember).isEqualTo(member2);
        
    }

    @Test
    void findByName_없을떄() {
        //Given
        Member member1 = new Member();
        member1.setName("일등이");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("이등이");
        repository.save(member2);

        //When
        Optional<Member> optionalMember2 =  repository.findByName("이등이2");

        //Then;
        assertThat(optionalMember2).isEmpty();

    }

}