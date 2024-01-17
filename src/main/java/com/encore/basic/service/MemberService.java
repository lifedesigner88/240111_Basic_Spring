package com.encore.basic.service;
import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.JpaMemberRepository;
import com.encore.basic.repository.MemberRepository;
import com.encore.basic.repository.MybatisMemberRepository;
import com.encore.basic.repository.SpringDataJpaMemberRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
         // 모든 메서드에 각각 트렌젝션 적용.
public class MemberService {

    private final MemberRepository repository;

    public MemberService(@Autowired SpringDataJpaMemberRopository repository) {
        this.repository = repository;
    }

    @Transactional
    public void memberCreate(MemberReqDto reqDto) throws IllegalAccessException {
//        repository.save(
//                new Member(
//                        reqDto.getName(),
//                        reqDto.getEmail(),
//                        reqDto.getPassword()
//                ));

        Member member = new Member(
                reqDto.getName(),
                reqDto.getEmail(),
                reqDto.getPassword());
        repository.save(member);

        if (reqDto.getName().equals("kim")) {
                throw new IllegalAccessException();
        }

    }

    public List<MemberResDto> members() {
        List<MemberResDto> DtoList = new ArrayList<>();
        List<Member> members = repository.findAll();
        for (Member member : members)
            DtoList.add(resDto(member));
        return DtoList;
    }

    public MemberResDto member(int id) throws EntityNotFoundException {
        return resDto(
                repository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }

    private MemberResDto resDto(Member member){
        return new MemberResDto(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPassword(),
                member.getCreated_time()
        );
    }
}
