package com.encore.basic.repository;

import com.encore.basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 가장 오래된 데이터 베이스 객체.
@Repository
public class JdbcMemberRepository implements MemberRepository{
    final String FIND_ALL_QUERY = "SELECT * FROM member";
    final String SAVE_QUERY = "INSERT INTO member(name, email, password) values(?,?,?)";
    final String FIND_BY_ID_QUERY = "SELECT * FROM member WHERE id = ?";

    //    datasource는 DB와 JDBC에서 사용하는 DB연결 드라이버 객체
    private final DataSource dataSource;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        try {
            PreparedStatement prepState = getPrepState(SAVE_QUERY);
            prepState.setString(1, member.getName());
            prepState.setString(2, member.getEmail());
            prepState.setString(3, member.getPassword());
            prepState.executeUpdate();
        } catch (Exception e) {throw new RuntimeException(e);}
        return null;
    }

    @Override
    public List<Member> findAll() {
        try {
            PreparedStatement prepState = getPrepState(FIND_ALL_QUERY);
            ResultSet resultSet = prepState.executeQuery();
            List<Member> members = new ArrayList<>();
            while (resultSet.next())
                members.add(getMember(resultSet));
            return members;
        } catch (Exception e) {throw new RuntimeException(e);}
    }

    @Override
    public Optional<Member> findById(int id) {
        try {
            PreparedStatement prepState = getPrepState(FIND_BY_ID_QUERY);
            prepState.setInt(1, id);
            ResultSet resultSet = prepState.executeQuery();
            if (resultSet.next())
                return Optional.of(getMember(resultSet));
            else
                return Optional.empty();
        } catch (Exception e) {throw new RuntimeException(e);}
    }


    private PreparedStatement getPrepState(String QUERY) throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection.prepareStatement(QUERY);
    }

    private Member getMember(ResultSet resultSet) throws SQLException {
        Member member = new Member(
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("password"));
        member.setId(
                resultSet.getInt("id"));
        member.setCreated_time(
                resultSet.getTimestamp("create_time").toLocalDateTime());
        return member;
    }
}
