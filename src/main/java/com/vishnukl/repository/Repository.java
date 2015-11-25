package com.vishnukl.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository {
    protected Connection connection;
    protected String TABLE_NAME;

    protected ResultSet fetchQuery() throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(String.format("select * from %s", TABLE_NAME));
    }

    protected List<?> populate(ResultSetProcessor processor) throws SQLException {
        List<?> list = new ArrayList<>();
        ResultSet resultSet = fetchQuery();
        while (resultSet.next()) {
            processor.process(resultSet, list);
        }
        resultSet.close();
        return list;
    }
}
