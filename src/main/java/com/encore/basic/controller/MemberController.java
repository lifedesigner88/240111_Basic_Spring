package com.encore.basic.controller;

import Print.Print;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1. 회원목록 조회
 * getMapping , 화면
 * url : members
 * 화면 : member/member-list
 * => 이름, email, password
 * => 테이블 구조 -> td는 적당히 3줄정도 채워주세요
 * <p>
 *
 * 2. 회원가입
 * url:명 : -> Getmapping(member/create-screen), PostMapping(member/create-create-screen)
 * 화면 : member/member-create 화면은 form data 형식
 **/


@Controller
public class MemberController extends Print {

    private MemberService memberService;

    MemberController() {
        this.memberService = new MemberService();
    }


    @GetMapping("/")
    public String home(){return "/member/home";}


    @GetMapping("members")
    public String getMembers(Model model) {
        model.addAttribute("memberList", memberService.members());
        return "member/member-list";
    }


    @GetMapping("member/create")
    public String getCreateFrom() {
        return "member/member-create";
    }


    @PostMapping("/member/create")
    public String postMemberCreate(MemberReqDto reqDto){
        memberService.memberCreate(reqDto);
        return "member/home";
    }
}
