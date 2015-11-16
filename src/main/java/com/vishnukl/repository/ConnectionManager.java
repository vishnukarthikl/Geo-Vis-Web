package com.vishnukl.repository;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String host = "localhost";
    private static String port = "1521";
    private static String sid = "xe";
    private static String username = "SYSTEM";
    private static String password = "lviss";

    public static Connection getConnection()
            throws SQLException {
        String thinConn = String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, sid);
        Driver d = new OracleDriver();
        Connection conn = DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
    }
}
