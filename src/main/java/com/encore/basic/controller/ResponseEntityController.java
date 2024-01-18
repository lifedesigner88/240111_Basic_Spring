package com.encore.basic.controller;

import com.encore.basic.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("response/entity")
public class ResponseEntityController {


    //    ResponseStatus 어노테이션 방식
    @GetMapping("responseStatus1")
    @ResponseStatus(HttpStatus.CREATED)
    public String responseStatus() {
        return "ok";
    }


    @GetMapping("responseStatus2")
    @ResponseStatus(HttpStatus.CREATED)
    public Member getMember() {
        return new Member("temp", "life", "123124");
    }


    //    ResponseEntity객체를 직접 생성한 방식.
    @GetMapping("custom1")
    public ResponseEntity<Member> custom1() {
        Member member = new Member("John", "john@example.com", "password");
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }


    //    Test/html로 설정
    @GetMapping("custom2")
    public ResponseEntity<String> custom2() {
        String html = "<h1>없는 ID 입니다</h1>";
        return new ResponseEntity<>(html, HttpStatus.NOT_FOUND);
    }


    //    map 형태의 메시지 커스텀
    @GetMapping("map_custom1")
    public static ResponseEntity<Map<String, Object>> errRsponseMessage(HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", Integer.toString(status.value()));
        map.put("status message", status.getReasonPhrase());
        map.put("error message", message);
        return new ResponseEntity<>(map, status);
    }


    @GetMapping("map_custom2")
    public static ResponseEntity<Map<String, Object>> responseMessage(HttpStatus status, Object object) {
        Map<String, Object> map2 = new HashMap<>();
        Member member = new Member("John", "john@example.com", "password");
        map2.put("error message", member);
        return new ResponseEntity<>(map2, status);
    }


//    메서드 체니이 :
    @GetMapping("chaining1")
    public ResponseEntity<Member> chaining1(){
         Member member3 = new Member("John", "john@example.com", "password");
        return ResponseEntity.ok(member3);
    }


    @GetMapping("chaining2")
    public ResponseEntity<Member> chaining2(){
        return ResponseEntity.notFound().build();
    }

    @GetMapping("chaining3")
    public ResponseEntity<Member> chaining3(){
        Member member4 = new Member("John", "john@example.com", "password");
        return ResponseEntity.status(HttpStatus.CREATED).body(member4);
    }

}



















