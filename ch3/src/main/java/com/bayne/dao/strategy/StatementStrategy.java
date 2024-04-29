package com.bayne.dao.strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementStrategy {

    PreparedStatement makePreparedStatement(Connection con) throws SQLException;
}
