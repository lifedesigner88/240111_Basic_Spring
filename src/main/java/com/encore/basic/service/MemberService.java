package com.encore.basic.service;
import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.MemberRepository;
import com.encore.basic.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    static int total_id;
    private final MemberRepository memberRepository;

    public MemberService(@Autowired MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberCreate(MemberReqDto reqDto) {
        memberRepository.memberCreate(
                new Member(
                        total_id++,
                        reqDto.getName(),
                        reqDto.getEmail(),
                        reqDto.getPassword(),
                        LocalDateTime.now()));
    }

    public List<MemberResDto> members() {
        List<MemberResDto> resDtos = new ArrayList<>();
        List<Member> members = memberRepository.members();

        for (Member member : members)
            resDtos.add(
                    new MemberResDto(
                            member.getId(),
                            member.getName(),
                            member.getEmail(),
                            member.getPassword()));
        return resDtos;
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
