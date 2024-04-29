package com.bayne.config;

import com.bayne.dao.ConnectionMaker;
import com.bayne.dao.ConnectionMakerImpl;
import com.bayne.dao.JdbcContext;
import com.bayne.dao.UserDao;
import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class UserDaoConfiguration {

    @Bean
    public UserDao userDao() throws SQLException {
        return new UserDao(dataSource(), jdbcContext());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new ConnectionMakerImpl();
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://localhost:3306/toby", "root", "1234");
    }

    @Bean
    public JdbcContext jdbcContext() throws SQLException {
        return new JdbcContext(dataSource());
    }
}
