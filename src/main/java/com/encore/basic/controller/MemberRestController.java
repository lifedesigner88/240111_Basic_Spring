package com.encore.basic.controller;
import Print.Print;
import com.encore.basic.domain.MemberReqDto;
import com.encore.basic.domain.MemberResDto;
import com.encore.basic.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(tags = "회원관리서비스")
@RestController
@RequestMapping("/rest")
public class MemberRestController extends Print {

    private final MemberService memberService;
    public MemberRestController(@Autowired MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("member/create")
    public String postMemberCreate(@RequestBody MemberReqDto reqDto) {
        memberService.memberCreate(reqDto);
        return "OK";
    }

    @GetMapping("members")            // 목록 조회
    public List<MemberResDto> getMembers() {
        return memberService.members();
    }

    @GetMapping("member/find/{id}")         // 디테일 화면 보여주기
    public ResponseEntity<Map<String, Object>> forDetail(@PathVariable int id) {
        MemberResDto memberResDto;
        try {
            memberResDto = memberService.member(id);
            return ResponseEntityController
                    .responseMessage(HttpStatus.OK, memberResDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntityController
                    .errRsponseMessage(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("member/delete/{id}")
    public String delete(@PathVariable int id) {
        memberService.deleteMember(id);
        return "ok";
    }

    @PatchMapping("/member/update")
    public MemberResDto update(@RequestBody MemberReqDto reqDto) {
        return memberService.update(reqDto);
    }

    @PostMapping("httpservlet")
    @ResponseBody
    public String httpServletTest(HttpServletRequest req){
//        HttpServelRequest객체에서 header 정보 추출
        print(req.getContentType());
        print(req.getMethod());
//        session : 로그인(auth) 정보에서 필요한 정보값을 추출할 때 많이 사용
        print("Se" + req.getSession());
        print(req.getHeader("Accept"));

//        httpSevletRequest 객체에서 body 정보 호출
        print(req.getParameter("test1"));
        print(req.getParameter("test2"));
        return "OK";
    }

}
