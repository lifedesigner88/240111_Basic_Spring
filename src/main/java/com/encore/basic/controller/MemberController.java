package com.encore.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
     1. 회원목록 조회
     getMapping , 화면
     url : members
     화면 : member/member-list
     => 이름, email, password
     => 테이블 구조 -> td는 적당히 3줄정도 채워주세요


     2. 회원가입
    url:명 : -> Getmapping(member/create-screen), PostMapping(member/create)
    화면 : member/member-create 화면은 form data 형식

 **/


@Controller
public class MemberController {
    @RequestMapping("/members")
    public String getMembers() {
        return "members";
    }
}
