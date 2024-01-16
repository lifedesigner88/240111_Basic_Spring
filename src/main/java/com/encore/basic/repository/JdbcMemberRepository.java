package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Repository
public class JdbcMemberRepository implements MemberRepository{
//    datasource는 DB와 JDBC에서 사용하는 DB연결 드라이버 객체

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(int id) {
        return Optional.empty();
    }
}
