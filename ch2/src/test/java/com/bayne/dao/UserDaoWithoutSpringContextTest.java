package com.bayne.dao;

import com.bayne.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoWithoutSpringContextTest {

    UserDao sut;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource datasource = new SingleConnectionDataSource("jdbc:mysql://localhost:3306/toby", "root", "1234", true);
        sut = new UserDao(datasource);
        sut.deleteAll();
    }

    @Test
    void add_a_new_user() throws SQLException {
        // given
        User user = new User("id");
        user.setName("name");
        user.setPassword("password");

        // when
        sut.add(user);

        // then
        User userFromDb = sut.get("id");
        assertEquals(user.getId(), userFromDb.getId());
        assertEquals(user.getName(), userFromDb.getName());
        assertEquals(user.getPassword(), userFromDb.getPassword());
    }
}
