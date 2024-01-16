package com.encore.basic.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
//@NoArgsConstructor   // (기본생성자)

@Getter
//@AllArgsConstructor    // (모든 매개변수 생성자)
public class Member {
    @Setter
    private int id;

    private final String name;
    private final String email;
    private final String password;

    @Setter
    private LocalDateTime create_time;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}