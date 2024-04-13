package com.bayne.dao;

import com.bayne.model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void add_a_new_user() throws SQLException, ClassNotFoundException {
        // given
        UserDao sut = new UserDao();
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
