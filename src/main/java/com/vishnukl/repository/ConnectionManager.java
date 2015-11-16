package com.vishnukl.repository;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection(String host,
                                           String port,
                                           String sid,
                                           String username,
                                           String password)
            throws SQLException {
        String thinConn = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
        Driver d = new OracleDriver();
        Connection conn = DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
    }
}
