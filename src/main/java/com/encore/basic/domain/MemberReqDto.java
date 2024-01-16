package com.encore.basic.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class MemberReqDto {
    private String name;
    private String email;
    private String password;
}