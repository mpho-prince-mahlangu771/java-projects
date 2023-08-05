package com.mycompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Account {

    private int customerId;
    private String accountNumber;
    private double balance;
    private String whenAccountCreated;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void createAccountNumber (int cust_id) {
            /*
         * algorithm to create an account number:
         * Datecreated + customer_id + random number between 1-500 
         * This results in format: yyyyMmddcustCountRandomNumber
         * example 1: 20230724198 - where 2023 is year, 07 is month, 24 is day, 1 is first customer, 98 is random #
         * example 2: 20230407255
        */

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuMMdd");
        String currentDate = LocalDate.now().format(formatter);
        int randomNumber = new Random().nextInt(100);
        this.customerId = cust_id;
        this.accountNumber = currentDate + customerId + randomNumber;
    }

    public void setAccountNumber(String accountNumber) {
       this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getWhenAccountCreated() {
        return whenAccountCreated;
    }

    public void setWhenAccountCreated(String creationDate) {
        this.whenAccountCreated = creationDate;
    }

}
