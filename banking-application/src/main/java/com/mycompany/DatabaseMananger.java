package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMananger {
    
    public static Connection connect() {

        String db_file = "jdbc:sqlite:src/main/java/com/mycompany/fake-bank.db";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(db_file);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
