package com.encore.basic.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//@NoArgsConstructor   // (기본생성자)

@Getter
@AllArgsConstructor    // (모든 매개변수 생성자)
public class Member {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime create_time;
}
