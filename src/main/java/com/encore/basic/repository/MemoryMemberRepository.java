package com.encore.basic.repository;
import com.encore.basic.domain.Member;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> MemberDb = new ArrayList<>();
    int total_id;

    @Override
    public List<Member> findAll() {
        return MemberDb;
    }

    @Override
    public Member save(Member member) {
        member.setId(total_id++);
        member.setCreated_time(LocalDateTime.now());
        MemberDb.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
        for (Member a : MemberDb)
            if (a.getId() == id) return Optional.of(a);
        return Optional.empty();
    }
}