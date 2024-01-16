package com.encore.basic.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberReqDto {
    private String name;
    private String email;
    private String password;
}