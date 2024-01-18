package com.encore.basic.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
//@AllArgsConstructor  // 세터로 유동적으로 사용.
public class MemberReqDto {
    private int id;
    private String name;
    private String email;
    private String password;
}