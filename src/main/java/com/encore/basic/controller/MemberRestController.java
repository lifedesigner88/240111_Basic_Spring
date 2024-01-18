package com.encore.basic.controller;

import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MemberRestController {

    private final MemberService memberService;
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("member/create")
    public String postMemberCreate(@RequestBody MemberReqDto reqDto)  {
            memberService.memberCreate(reqDto);
            return "OK" ;
    }

    @GetMapping("members")            // 목록 조회
    public List<MemberResDto> getMembers() {
        return memberService.members();
    }


    @GetMapping("member/find/{id}")         // 디테일 화면 보여주기
    public ResponseEntity<MemberResDto> forDetail(@PathVariable int id) {
        MemberResDto memberResDto;
        try {
            memberResDto = memberService.member(id);
            return new ResponseEntity<>(memberResDto, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("member/delete/{id}")
    public String delete(@PathVariable int id){
            memberService.deleteMember(id);
            return "ok";
    }

    @PatchMapping("/member/update")
    public MemberResDto update(@RequestBody MemberReqDto reqDto){
            return memberService.update(reqDto);
    }

}
