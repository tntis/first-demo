package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    // Open-Closed Pricipal(OCP)

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member); // 조회했을 시에 값이 없을수도 있기떄문에 ofNullable 로 확인
    }

    @Override
    public Optional<Member> findByName(String name) {
        // JPQL(Java Persistence Query Language)
        String jpql = "select m from Member m where name = :name";
        List<Member> members = em.createQuery(jpql, Member.class)
                .setParameter("name", name)
                .getResultList();
        return members.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        String jpql = "select m from Member m";
        return em.createQuery(jpql, Member.class)
                .getResultList();
    }
}
