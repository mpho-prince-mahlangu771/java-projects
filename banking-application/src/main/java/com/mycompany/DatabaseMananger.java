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
            System.out.println("we're connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Customer getCustomer(String email) {
        String sql = "SELECT * FROM customers WHERE cust_email=?";
        Customer customer = null;

        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);

            try(ResultSet resultSet = statement.executeQuery()) {
                customer = new Customer();
                resultSet.getInt("cust_id");
                resultSet.getString("cust_first_name");
                resultSet.getString("cust_middle_name");
                resultSet.getString("cust_last_name");
                resultSet.getString("cust_date_of_birth");
                resultSet.getString("cust_gender");
                resultSet.getString("cust_phone");
                resultSet.getString("cust_email");
                resultSet.getString("cust_password");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static void main(String... args) {
       Customer customer = getCustomer("mp@gmail.com");
       System.out.println(customer.getFirstName());
    }
}
