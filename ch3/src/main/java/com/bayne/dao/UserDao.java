package com.bayne.dao;

import com.bayne.dao.strategy.StatementStrategy;
import com.bayne.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void jdbcContextWithStatementStrategy(final StatementStrategy stmt) throws SQLException {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(con)) {
            ps.executeUpdate();
        }
    }

    public void add(final User user) throws SQLException {
        Connection con = dataSource.getConnection();

        try (PreparedStatement ps = con.prepareStatement("insert into user(id, name, password) values(?, ?, ?)")) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            con.close();
        }
    }

    public User get(final String id) throws SQLException {
        Connection con = dataSource.getConnection();

        try (PreparedStatement ps = con.prepareStatement("select * from user where id = ?")) {
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));

            rs.close();
            con.close();

            return user;
        }
    }

    public void deleteAll() throws SQLException {
        jdbcContextWithStatementStrategy(con -> con.prepareStatement("delete from user"));
    }
}
