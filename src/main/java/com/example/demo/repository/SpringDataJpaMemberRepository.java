package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// Spring Data : 공통
// Spring Data JPA :RDB(ORM)
// JPA vs. Hinernate
// JPA vs. 스프링 데이터 JPA

// Spring MVC - 아는 사람이 많다. 왠만큼 알아서는 경쟁력이 없다.
// JPA - 아는 사람이 (생각보다) 많이 없다. 어느정도 알면 경쟁력이 생긴다.



public interface SpringDataJpaMemberRepository extends MemberRepository, JpaRepository<Member,Long> {

  //  Optional<Member> findById(Long id);
}
