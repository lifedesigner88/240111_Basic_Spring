package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 Srping data jpa의 기본기능을 쓰기 위해서는 jpaRepository를 상속해야함
 상속시에 entity명과 해당 entity의 pk 타입을 명시
 실질적인 구현 클래스와 SimpleJapRepository 클래스에 있고,
 실질적인 구동 상황에서 hibernate 구현체에 동작을 위임한다.
*/
@Repository
public interface SpringDataJpaMemberRopository
        extends MemberRepository, JpaRepository<Member, Integer> {
}
