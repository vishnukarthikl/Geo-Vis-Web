package com.vishnukl.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface ResultSetProcessor {
    void process(ResultSet resultSet, List collector) throws SQLException;
}
