package com.bayne.dao;

import com.bayne.dao.strategy.StatementStrategy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {

    private final DataSource dataSource;

    public JdbcContext(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void workWithStatementStrategy(final StatementStrategy stmt) throws SQLException {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(con)) {
            ps.executeUpdate();
        }
    }
}
