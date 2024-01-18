package com.encore.basic.controller;

import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.service.MemberService;
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



    @PostMapping("/member/create")
    public String postMemberCreate(MemberReqDto reqDto)  {
            memberService.memberCreate(reqDto);
            return "OK" ;
    }

/*

    @GetMapping("members")            // 목록 조회
    public List<MemberResDto> getMembers() {
        List<MemberResDto> members = memberService.members();
        return ;
    }


    @GetMapping("/member/find")         // 디테일 화면 보여주기
    public MemberResDto forDetail(@RequestParam("id") int id, Model model) {
            MemberResDto member = memberService.member(id);
            model.addAttribute("detail", member);
            return ;
    }

    @DeleteMapping("/member/delete")
    public String delete(@RequestParam("id") int id){
            memberService.deleteMember(id);
            return "ok";

    }

    @PatchMapping("/member/update")
    public MemberResDto update(MemberReqDto reqDto){
            return memberService.update(reqDto);
    }
*/

}
