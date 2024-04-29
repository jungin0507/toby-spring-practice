package com.bayne.dao;

import com.bayne.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {

    static UserDao sut;

    @BeforeAll
    static void beforeAll() {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        sut = context.getBean("userDao", UserDao.class);
    }

    @BeforeEach
    void setUp() {
        sut.deleteAll();
    }

    @Test
    void add_a_new_user() {
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

    @Test
    void get_all_users_order_by_id() {
        // given
        User user1 = new User("id1");
        user1.setName("name1");
        user1.setPassword("password1");
        sut.add(user1);

        User user2 = new User("id2");
        user2.setName("name2");
        user2.setPassword("password2");
        sut.add(user2);

        // when
        var users = sut.getAll();

        // then
        assertEquals(2, users.size());
        assertEquals(user1.getId(), users.get(0).getId());
        assertEquals(user2.getId(), users.get(1).getId());
    }
}
