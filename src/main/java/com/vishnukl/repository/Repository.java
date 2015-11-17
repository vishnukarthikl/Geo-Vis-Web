package com.vishnukl.repository;

import java.sql.*;

public abstract class Repository {
    protected Connection connection;
    protected String TABLE_NAME;

    protected ResultSet fetchQuery() throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(String.format("select * from %s", TABLE_NAME));
    }
}
