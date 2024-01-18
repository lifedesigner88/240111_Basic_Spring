package com.encore.basic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

// Entity 어노테이션을 통해서 마리아DB의 테이블 및 컬럼을 자동 생성
// 클래스명은 테이블명, 변수명은 컬럼명
@Entity
// 모든 매개변수를 넣은 생성자! -> 기본생성자가 사라진다.
// @NoArgsConstructor(기본생성자)와 @RequiredArgsConstructor 등도 있다.
@NoArgsConstructor
@Data
public class Member {

    @Id //PK 설정
    // GenerationType.IDENTITY: auto_increment 설정,
    // GenerationType.AUTO: JPA 구현체가 자동으로 적절한 키 생성 전략을 선택
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // String은 DB의 varchar로 변환

    private String name;

    @Column(nullable = false, length = 50)  // name 옵션을 통해서 DB의 컬럼명 별도 지정 가능
    private String email;

    private String password;

    @Column  // (name = "created_time")  // name 옵션을 통해서 DB의 컬럼명을 별도 지정이 가능하다.
    @CreationTimestamp
    private LocalDateTime created_time;   // DB에 들어갈 정보이지만, 사용자가 입력할 값은 아님.

    @UpdateTimestamp
    private LocalDateTime updateTime;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}


