package com.encore.basic.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
// Entity 어노테이션을 통해서 마리아DB의 테이블 및 컬럼을 자동 생성
// 클래스명은 테이블명, 변수명은 컬럼명
@Entity
// 모든 매개변수를 넣은 생성자! -> 기본생성자가 사라진다.
// @NoArgsConstructor(기본생성자)와 @RequiredArgsConstructor 등도 있다.
@NoArgsConstructor
public class Member {

    @Setter
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

    @Setter
    @Column(name = "created_time")  // name 옵션을 통해서 DB의 컬럼명을 별도 지정이 가능하다.
    private LocalDateTime create_time;   // DB에 들어갈 정보이지만, 사용자가 입력할 값은 아님.


    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.create_time = LocalDateTime.now();
    }
}


//
//package com.encore.basic.domain;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
////@NoArgsConstructor   // (기본생성자)
////@AllArgsConstructor    // (모든 매개변수 생성자)

//@Getter
//@Entity

//// entity 어노테이션을 통해 mriadb의 테이블 및 컬럼을 자동생성
//// class 명은 테이블명, 변수명은 컬럼명

//@NoArgsConstructor
//public class Member {
//    @Setter
//    @Id             // pk 설정.
//    // identity = auto_increment 설정. auto=JPA구현체가 자동으로 선택
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    //    String은 DB의 varchar로 변환
//    private final String name;
//
//    @Column(nullable = false, length = 50)
//    private final String email;
//
//    private final String password;
//
//    @Setter
//    @Column (name="created_time") // DB에 컬럼명 별도 지정가능.
//    private LocalDateTime create_time;
//
//    public Member(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }


