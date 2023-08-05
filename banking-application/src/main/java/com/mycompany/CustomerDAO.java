package com.mycompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getPassword());
            int rowsAffected = statement.executeUpdate();
            
                if(rowsAffected > 0) {
                    try(ResultSet rs = statement.getGeneratedKeys()) {
                        if(rs.next()) {
                            int dbGeneratedId = rs.getInt(1);
                            customer.setCustomerId(dbGeneratedId);
                        }
                    }
                    return rowsAffected > 0; // or true
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }   

        return false;
    }

    public static String getcustomerPhone(String cust_phone) {
        String SELECT = "SELECT cust_phone FROM customers WHERE cust_phone=?";
        String db_phone = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {
                statement.setString(1, cust_phone);
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()) {
                    db_phone = rs.getString("cust_phone");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return db_phone;
    }

    public static String getCustomerEmail(String cust_email) {
        String SELECT = "SELECT cust_email FROM customers WHERE cust_email=?";
        String db_email = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {
                statement.setString(1, cust_email);
                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    db_email = rs.getString("cust_email");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return db_email;
    }

    public static Customer getCustomer(String username) {
        String SELECT = "SELECT * FROM customers WHERE cust_email=? OR cust_phone=?";
        Customer customer = null;
        ResultSet resultSet = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {

            statement.setString(1, username);
            statement.setString(2, username);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("cust_id"));
                customer.setFirstName(resultSet.getString("cust_first_name"));
                customer.setMiddleName(resultSet.getString("cust_middle_name"));
                customer.setSurname(resultSet.getString("cust_last_name"));
                customer.setDateOfBirth(resultSet.getString("cust_date_of_birth"));
                customer.setGender(resultSet.getString("cust_gender"));
                customer.setPhoneNumber(resultSet.getString("cust_phone"));
                customer.setEmail(resultSet.getString("cust_email"));
                customer.setPassword(resultSet.getString("cust_password"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static Customer updateCustomer(Customer customer){
        return null;
    }


    public static Customer deleteCustomer(Customer customer){
        return null;
    }
}
