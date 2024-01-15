package com.encore.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class MemberReqDto {
    private String name;
    private String email;
    private String password;
}
