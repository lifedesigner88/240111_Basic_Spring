package com.encore.basic.service;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberRequestDto;
import com.encore.basic.repository.MemoryMemberRepository;

import java.util.List;

public class MemberService {

    private final MemoryMemberRepository memoryMemberRepository;

    public MemberService() {
        memoryMemberRepository = new MemoryMemberRepository();
    }

    public List<Member> members() { return memoryMemberRepository.members();}

    public void memberCreate(MemberRequestDto memberRequestDto) {



    }

}
