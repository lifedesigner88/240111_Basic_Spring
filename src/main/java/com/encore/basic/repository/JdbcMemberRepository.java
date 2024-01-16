package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;


@Repository
public class JdbcMemberRepository implements MemberRepository{
//    datasource는 DB와 JDBC에서 사용하는 DB연결 드라이버 객체

    private final DataSource dataSource;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {

        try {
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO member(name, email, password) values(?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(sql);
            prepState.setString(1, member.getName());
            prepState.setString(2, member.getEmail());
            prepState.setString(3, member.getPassword());
            prepState.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return null;

    }



    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Optional<Member> findById(int id) {
        return Optional.empty();
    }
}
