package com.encore.basic.repository;

import com.encore.basic.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository {
    private final List<Member> MemberDb;

    public MemoryMemberRepository() {
        MemberDb = new ArrayList<>();
    }

    public List<Member> members() {return MemberDb;}

    public void memberCreate(Member member) {MemberDb.add(member);}
}
