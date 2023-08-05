package com.mycompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    
    public static boolean createAccount(Account account, Customer customer){
        String INSERT = "INSERT INTO accounts (acc_number, acc_balance, active_since, cust_id)" +
                        "VALUES(?, ?, ?, ?)";
        
        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, account.getAccountNumber());
            statement.setDouble(2, account.getBalance());
            statement.setString(3, account.getWhenAccountCreated());
            statement.setInt(4, customer.getCustomerId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Account selectAll(int cust_id) {
        String SELECT = "SELECT * FROM accounts WHERE cust_id=?";
        Account account = null;
        ResultSet rs = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {
                statement.setInt(1, cust_id);
                rs = statement.executeQuery();

                while(rs.next()) {
                    account = new Account();
                    account.setAccountNumber(rs.getString("acc_number"));
                    account.setBalance(rs.getDouble("acc_balance"));
                    account.setWhenAccountCreated(rs.getString("active_since"));
                    account.setCustomerId(rs.getInt("cust_id"));
                }
            } catch(SQLException e) {
                System.out.println("Error executing sql query, reason: " + e.getMessage());
            }

        return account;
    }
    public static String selectAccountNumber(String acc_number) {
        String SELECT = "SELECT acc_number FROM accounts WHERE acc_number=?";
        String db_accountNumber = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {
                statement.setString(1, acc_number);
                ResultSet rs = statement.executeQuery();

                while(rs.next()) {
                    db_accountNumber = rs.getString("acc_number");
                }
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        return db_accountNumber;
    }
    //fix urgently
    public static Account getAccount(String acc_number ) {
        String SELECT = "SELECT * FROM accounts WHERE acc_number=?";
        Account account = null;
        ResultSet rs = null;

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(SELECT)) {
                statement.setString(1, acc_number);
                rs = statement.executeQuery();

                while(rs.next()) {
                    account = new Account();
                    account.setAccountNumber(rs.getString("acc_number"));
                    account.setBalance(rs.getDouble("acc_balance"));
                    account.setWhenAccountCreated(rs.getString("active_since"));
                    account.setCustomerId(rs.getInt("cust_id"));
                }
            } catch(SQLException e) {
                System.out.println("Error executing sql query, reason: " + e.getMessage());
            }

        return account;
    }

    public static void depositMoney(Double balance, String accNumber) {
        String UPDATE = "UPDATE accounts SET acc_balance=? WHERE acc_number=?";

        try(Connection connection = DatabaseMananger.connect();
            PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                statement.setDouble(1, balance);
                statement.setString(2, accNumber);
                statement.executeUpdate();
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public static void deleteAccount(int cust_id) {
        String DELETE = "DELETE FROM accounts WHERE cust_id=?";

        try(Connection connection = DatabaseMananger.connect();
        PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, cust_id);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
