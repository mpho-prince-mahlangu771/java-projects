package com.mycompany;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

/*
 * Returns true if:
 * no inputs are blank
 * all inputs  are in valid format
 * are non-existent values(email/phone # not registered)
 */

public class UserInputValidator {

    private static boolean checkFirstName;
    private static boolean checkMiddleName;
    private static boolean checkSurname;
    private static boolean checkDateOfBirth;
    private static boolean checkGender;
    private static boolean checkPhone;
    private static boolean checkPhoneRegistration;
    private static boolean checkEmail;
    private static boolean checkEmailRegistration;
    private static boolean checkPassword;
    private static boolean checkAge;
    private static String firstNameErr = "";
    private static String middleNameErr = "";
    private static String surnameErr = "";
    private static String dateOfBirthErr = "";
    private static String genderErr = "";
    private static String phoneErr = "";
    private static String emailErr = "";
    private static String phoneRegisteredErr = "";
    private static String emailRegisteredErr = "";
    private static String passwordErr = "";

    public static boolean isFirstNameValid(String firstName) {
        boolean firstNameMatches = Pattern.matches("[a-zA-Z]+", firstName);
        if(firstNameMatches) return true;
        else return false;
    }

    public static boolean isMiddleNameValid(String middleName) {
        boolean middleNameMatches = Pattern.matches("[a-zA-Z]+", middleName);
        if(middleNameMatches) return true;
        else return false;
    }

    public static boolean isLastNameValid(String lastName) {
        boolean lastNameMatches = Pattern.matches("[a-zA-Z]+", lastName);
        if(lastNameMatches) return true;
        else return false;
    }

    public static boolean isEmailValid(String email){
        boolean emailMatches = Pattern.matches("^(\\w)+@[a-zA-Z]+.[a-zA-Z]+", email);
        if(emailMatches) return true;
        else return false;
    }

    //when db_email is null it means the email does not exist in customers db
    public static boolean isEmailRegistered(String unverified_email){
        String db_email = CustomerDAO.getCustomerEmail(unverified_email);
        if(db_email != null) return true;
        else return false;
    }

    public static boolean isPhoneValid(String phone) {
        boolean phoneMatches = Pattern.matches("^0\\d{9}", phone);
        if(phoneMatches) return true;
        else return false;
    }

    //when db_phone is null it means the phone does not exist in customers db
    public static boolean isPhoneRegistered(String unverified_phone) {
        String db_Phone = CustomerDAO.getcustomerPhone(unverified_phone);
        if(db_Phone != null) return true;
        else return false;
    }

    public static boolean isPasswordValid(String password) {
        boolean passwordMatches = Pattern.matches("\\w{8,}", password);
        if(passwordMatches && !password.isBlank()) return true;
        else return false;
    }

    public static boolean isDateOfBirthValid(String dayOfbirth, String monthOfBirth, String yearOfBirth) {
        boolean dayOfBirthMatches = Pattern.matches("\\d{1,2}", dayOfbirth);
        boolean monthOfBirthMatches = Pattern.matches("\\d{1,2}", monthOfBirth);
        boolean yearOfBirthMatches = Pattern.matches("\\d{4}", yearOfBirth);

        if(dayOfBirthMatches && monthOfBirthMatches && yearOfBirthMatches) return true;
        else return false;
    }

    public static boolean isGenderValid(String gender) {
        if(gender.isBlank()) return false;
        else return true;
    }

     //must be a minimum of 16 years old and a maximum of 65 years old
     public static boolean isAgeValid(LocalDate dateOfBirth) {
        LocalDate current = LocalDate.now();
        Period period = Period.between(dateOfBirth, current);

        if(period.getYears() >= 16 && period.getYears() <= 65) {
            return true;
        } else return false;
    }

    public static boolean isAccountNumberValid(String accountNumber) {
        String db_accountNumber = AccountDAO.selectAccountNumber(accountNumber);
        
        if(db_accountNumber != null) return true;
        else return false;
    }

    public static boolean allInputsOk(String firstname, String middlename, String surname, String yearOfBirth,
                                      String monthOfBirth, String dayOfBirth, String gender, String phone,
                                      String email, String password) {

        checkFirstName = isFirstNameValid(firstname);
        checkMiddleName = isMiddleNameValid(middlename);
        checkSurname = isLastNameValid(surname);
        checkDateOfBirth = isDateOfBirthValid(dayOfBirth, monthOfBirth, yearOfBirth);
        checkPhone = isPhoneValid(phone);
        checkPhoneRegistration = isPhoneRegistered(phone);
        checkGender = isGenderValid(gender);
        checkEmail = isEmailValid(email);
        checkEmailRegistration = isEmailRegistered(email);
        checkPassword = isPasswordValid(password);

        if(checkFirstName && checkMiddleName && checkSurname && checkDateOfBirth && 
           checkPhone && checkPhone && checkGender && checkEmail && checkPassword && 
           !checkEmailRegistration && !checkPhoneRegistration) {

           return true;
           } else return false;
        
    }

    public static String firstNameError() {
        if(checkFirstName) return firstNameErr = "Firstname is....OK";
        else return firstNameErr = "firstname...Invalid format";
    }

    public static String middleNameError() {
        if(checkMiddleName) return middleNameErr = "Middlname is...OK";
        else return middleNameErr = "middlename...Invalid format";
    }

    public static String surnameError() {
        if(checkSurname) return surnameErr = "Surname is...OK";
        else return surnameErr = "surname...Invalid format";
    }

    public static String dateOfBirthError() {
        if(checkDateOfBirth) return dateOfBirthErr = "Date-Of-Birth is...OK";
        else return dateOfBirthErr = "Date-Of-Birth...Invalid format";
            
    }

    public static String genderError() {
        if(checkGender) return genderErr = "Gender is...OK";
        else return genderErr = "Gender...invalid format";
    }

    public static String phoneError() {
        if(checkPhone) return phoneErr = "Phone number is...OK";
        else return phoneErr = "Phone number...Invalid format";
    }

    public static String emailError() {
        if(checkEmail) return emailErr = "Email is...OK";
        else return emailErr = "Email...invalid format";
    }

    public static String passwordError() {
        if(checkPassword) return passwordErr = "Password is...OK";
        else return passwordErr = "Passwords do not match or invalid format";
    }

    public static String phoneRegistrationError() {
        if(checkPhoneRegistration) return phoneRegisteredErr = "Phone number already registered";
        else return phoneRegisteredErr = "Phone not registered";
    }

    public static String emailRegistrationError() {
        if(checkEmailRegistration) return emailRegisteredErr = "Email already registered";
        else return emailRegisteredErr = "Email is not registered";
    }

   



   
}
