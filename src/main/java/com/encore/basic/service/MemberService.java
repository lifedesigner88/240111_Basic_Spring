package com.encore.basic.service;

import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService {


    private final MemoryMemberRepository memoryMemberRepository;
    static int total_id;

    @Autowired
    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
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
