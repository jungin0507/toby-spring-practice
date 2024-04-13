package com.bayne.config;

import com.bayne.dao.ConnectionMaker;
import com.bayne.dao.ConnectionMakerImpl;
import com.bayne.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoConfiguration {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new ConnectionMakerImpl();
    }
}
