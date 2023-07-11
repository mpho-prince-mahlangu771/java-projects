package com.mycompany;

import java.time.LocalDate;
public class Customer {
    
    private String firstName;
    private String middleName;
    private String surname;
    private String dayOfBirth;
    private  String monthOfBirth;
    private String yearOfBirth;
    private String dateOfBirth;
    private String gender;
    private String cellphoneNumber;
    private String email;
    private String password;
    private String customerID; //autogenerate with database system

    public Customer() {}

    public Customer(String firstName, String middleName, String surname, String dayOfBirth, String monthOfBirth,
            String yearOfBirth, String dateOfBirth, String gender, String cellphoneNumber, String email, String password) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        this.dateOfBirth = dayOfBirth + "-" + monthOfBirth + "-"+ yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
