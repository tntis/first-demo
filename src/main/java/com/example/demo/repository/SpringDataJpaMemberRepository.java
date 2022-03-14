package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


// Spring Data : 공통
// Spring Data JPA :RDB(ORM)
// JPA vs. Hinernate
// JPA vs. 스프링 데이터 JPA

// Spring MVC - 아는 사람이 많다. 왠만큼 알아서는 경쟁력이 없다.
// JPA - 아는 사람이 (생각보다) 많이 없다. 어느정도 알면 경쟁력이 생긴다.


@NoRepositoryBean // -> Repository Bean으로 생성하지 않는다." 라고 선언 하는것
public interface SpringDataJpaMemberRepository extends MemberRepository, JpaRepository<Member,Long> {
    
    // 오버라이드 되어잇는것이기 때문에 넣어주지 않아도 동작
    // Optional<Member> findByName(String name);
}
