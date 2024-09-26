package com.inseo.hello_spring.repository;

import com.inseo.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id){

    }

    @Override
    public Optional<Member> findByName(String name) {

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());

}
