package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override // 재정의 메소드라는 명시적 표현 ; 없어도 정상 동작
    // 미 표출시 메소드 명이 변경될시 확인할 수 없음
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = store.get(id);
        return Optional.ofNullable(member);
    }


    public Member findById2(Long id) {
        return store.get(id);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // stream
        // Lambda
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void claerStore() {
        store.clear();

    }
}


