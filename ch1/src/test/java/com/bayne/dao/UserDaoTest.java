package com.bayne.dao;

import com.bayne.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(new ConnectionMakerImpl());
        userDao.deleteAll();
    }

    @Test
    void add_a_new_user() throws SQLException, ClassNotFoundException {
        // given
        UserDao sut = new UserDao(new ConnectionMakerImpl());
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
