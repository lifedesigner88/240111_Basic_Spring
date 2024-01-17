package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {

/*
    EntityManager는 JPA의 핵심클래서(객체)
    Entity 의 생명주기를 관리. 데이터베이스와의 모든 상호작용을 책임.
    엔티티를 대상으로 CRUD하는 기능을 제공.
*/

    private final EntityManager entityManager;
    public JpaMemberRepository(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Member> findAll() {
//        jpql : jpa의 객체지향 쿼리문법
//        장점 : db에 따라 문법이 달라지지 않는 객체지향 언어, 컴파일타임에서 check.(SpringData.JPA의 @Query 가능)
//        단점 : DB 고유의 기능과 성능을 극대화하기는 어려움.
        return entityManager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Member save(Member member) {
//        EntityManager의 관리상태가 되도록 만들어주고
//        트랜잭션이 커밋될 때 데이터 베이스에 저장. insert, update 포함.
        entityManager
                .persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {    //pk를 매개변수로 둔다.
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    public List<Member> findByName(String name){    //jpql JPQL
        return entityManager
                .createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
