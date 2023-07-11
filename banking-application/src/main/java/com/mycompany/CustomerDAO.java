package com.mycompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * This class is responsible for customer CRUD operations
 */
public class CustomerDAO {
    
    public static boolean insertCustomer(Customer customer) {
        String INSERT = "INSERT INTO customers (cust_first_name, cust_middle_name, cust_last_name," +
                        "cust_date_of_birth, cust_gender, cust_phone, cust_email, cust_password)" +
                        "VALUES(?,?,?,?,?,?,?,?)";

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getMiddleName());
            statement.setString(3, customer.getSurname());
            statement.setString(4, customer.getDateOfBirth());
            statement.setString(5, customer.getGender());
            statement.setString(6, customer.getCellphoneNumber());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getPassword());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }   

        return false;
    }
}
