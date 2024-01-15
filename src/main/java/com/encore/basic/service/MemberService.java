package com.encore.basic.service;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.MemoryMemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    static int total_id;
    private final MemoryMemberRepository memoryMemberRepository;

    public MemberService() {
        total_id = 0;
        memoryMemberRepository = new MemoryMemberRepository();
    }

    public List<MemberResDto> members() {
        List<MemberResDto> resDtos = new ArrayList<>();
        List<Member> members = memoryMemberRepository.members();

        for (Member member : members)
            resDtos.add(
                    new MemberResDto(
                    member.getName(),
                    member.getEmail(),
                    member.getPassword()));
        return resDtos;
    }

    public void memberCreate(MemberReqDto reqDto) {
        memoryMemberRepository.memberCreate(
                new Member(
                total_id++,
                reqDto.getName(),
                reqDto.getEmail(),
                reqDto.getPassword(),
                LocalDateTime.now()));
    }

}
