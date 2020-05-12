package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection createNewConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/versandwarenhausdb";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
