package com.bayne.dao;

import com.bayne.config.UserDaoConfiguration;
import com.bayne.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {

    static UserDao sut;

    @BeforeAll
    static void beforeAll() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserDaoConfiguration.class);
        sut = context.getBean("userDao", UserDao.class);
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        sut.deleteAll();
    }

    @Test
    void add_a_new_user() throws SQLException, ClassNotFoundException {
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
