package com.vishnukl.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {
    protected Connection connection;
    protected String TABLE_NAME;

    protected ResultSet fetchQuery() throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(String.format("select * from %s", TABLE_NAME));
    }
}
