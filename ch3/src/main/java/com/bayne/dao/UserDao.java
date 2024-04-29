package com.bayne.dao;

import com.bayne.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        return user;
    };

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) {
        jdbcTemplate.update("insert into user(id, name, password) values(?, ?, ?)",
                user.getId(),
                user.getName(),
                user.getPassword());
    }

    public User get(final String id) {
        return jdbcTemplate.queryForObject("select id, name, password from user where id = ?",
                new Object[]{id},
                new int[]{Types.VARCHAR},
                this.userMapper);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("select id, name, password from user order by id",
                this.userMapper);
    }

    public void deleteAll() {
        jdbcTemplate.update("delete from user");
    }
}
