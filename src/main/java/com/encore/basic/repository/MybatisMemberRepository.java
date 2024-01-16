package com.encore.basic.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// mybatis 레파지토리로 쓰겠다는 어노테이션

@Mapper
@Repository
public interface MybatisMemberRepository extends MemberRepository {
//    본문에 Myㅠㅁ샨Repository에서 사용할 메서드를 명세를 정의해야하나
//    MemberRepository에서 상송박도 있으므로, 생략가능.
//    실질적인 쿼ㄹ등 구현은 resources/mapper/MemberMapper.xml파일에 수행

}
