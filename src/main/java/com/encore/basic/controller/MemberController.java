package com.encore.basic.controller;

import Print.Print;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
//@RequiredArgsConstructor
public class MemberController extends Print {


    // Service 어노테이션을 통해 싱글통 컴포넌트로 생성 => 스프링 빈으로 등록
    // 스프링 빈이란 스프링이 생성하고 관리하는 객체를 의미
    // 제어의 역전(Inversion of Control) -> IOC컨테이너가 스프링 빈을 관리(빈을 생성,주입)


//    의존성 주입(DI)  필드 주입방식
//    @Autowired
//    private MemberService memberService;



//    의존성 주입 방법(2) 생성자 주입 방식.
//    장점 : final을통해 상수로 사용가능,
//    생성자가 1개 밖에 없을 때는 Autowired 생략 가능

    private final MemberService memberService;
    public MemberController(@Autowired MemberService memberService) {
        this.memberService = memberService;
    }



//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

//   의존성 주입방벙 (3) @RequiredArgsConstructor 이용한 방식
//    @RequiredArgsConstructor : @NonNull 어노테이션이 붙어있는 필드 또는
//    초기화 되지 않은 final 필드를 대상으로 생성자 생성.
//    @RequiredArgsConstructor // 클래스에
//    @NonNull
//    private MemberService memberService; // 한줄만
//     or
//    private final MemberService memberService; // 한줄만



    @GetMapping("/")
    public String home(){return "/member/header";}


    @GetMapping("members")
    public String getMembers(Model model) {
        model.addAttribute("memberList", memberService.members());
        return "/member/member-list";
    }


    @GetMapping("member/create")
    public String getCreateFrom() {
        return "/member/member-create";
    }


    @PostMapping("/member/create")
    public String postMemberCreate(MemberReqDto reqDto){
        memberService.memberCreate(reqDto);
        return "/member/header";
    }
}
