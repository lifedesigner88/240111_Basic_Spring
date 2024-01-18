package com.encore.basic.service;
import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.MemberRepository;
import com.encore.basic.repository.SpringDataJpaMemberRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
         // 모든 메서드에 각각 트렌젝션 적용.

@Transactional

public class MemberService {

    private final MemberRepository repository;

    public MemberService(@Autowired SpringDataJpaMemberRopository repository) {
        this.repository = repository;
    }

    public void memberCreate(MemberReqDto reqDto) throws IllegalArgumentException {
        repository.save(
                new Member(
                        reqDto.getName(),
                        reqDto.getEmail(),
                        reqDto.getPassword()
                ));

        if (reqDto.getName().equals("kim")) {
                throw new IllegalArgumentException();
        }
    }

    public List<MemberResDto> members() {
        List<MemberResDto> DtoList = new ArrayList<>();
        List<Member> members = repository.findAll();
        for (Member member : members)
            DtoList.add(memberToDto(member));
        return DtoList;
    }

    public MemberResDto member(int id) throws EntityNotFoundException {
        return memberToDto(
                repository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }

    public void deleteMember(int id) throws EntityNotFoundException {
        repository.delete(
                repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }


    public MemberResDto update(MemberReqDto reqDto){
        Member member = repository
                .findById(reqDto.getId())
                .orElseThrow(EntityNotFoundException::new);

        member.setName(reqDto.getName());
        member.setPassword(reqDto.getPassword());
        member = repository.save(member);

        return memberToDto(member);
    }




    private MemberResDto memberToDto(Member member){
        return new MemberResDto(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPassword(),
                member.getCreated_time()
        );
    }

}
