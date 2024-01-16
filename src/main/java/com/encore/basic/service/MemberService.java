package com.encore.basic.service;
import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.repository.JdbcMemberRepository;
import com.encore.basic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
    public MemberService(JdbcMemberRepository repository) {
        this.repository = repository;
    }

    public void memberCreate(MemberReqDto reqDto) {
        repository.save(
                new Member(
                        reqDto.getName(),
                        reqDto.getEmail(),
                        reqDto.getPassword()
                ));
    }

    public List<MemberResDto> members() {
        List<MemberResDto> DtoList = new ArrayList<>();
        List<Member> members = repository.findAll();
        for (Member member : members)
            DtoList.add(resDto(member));
        return DtoList;
    }

    public MemberResDto member(int id)
            throws NoSuchFieldException {
        return resDto(
                repository.findById(id)
                        .orElseThrow(NoSuchFieldException::new));
    }

    private MemberResDto resDto(Member member){
        return new MemberResDto(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPassword(),
                member.getCreate_time()
        );
    }

}
