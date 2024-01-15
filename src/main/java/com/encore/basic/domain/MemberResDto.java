package com.encore.basic.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResDto {
    private int id;
    private String name;
    private String email;
    private String password;
}
