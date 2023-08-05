package com.mycompany.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.mycompany.Account;
import com.mycompany.AccountDAO;
import com.mycompany.Customer;
import com.mycompany.CustomerDAO;
import com.mycompany.MenuHelper;
import com.mycompany.UserInputValidator;

public class Menu {
    
    public static void main(String[] args) throws Exception {
        //middlename and email are  optional - but a customer must choose to use either
        // a phone number or email as a username for login purposes

        boolean flag = true;
        boolean checkAge;
        boolean checkAllInputs;
        String firstName;
        String middleName =""; //optional
        String surname;
        String dateOfBirth;
        String yearOfBirth;
        String monthOfBirth;
        String dayOfBirth;
        String gender;
        String genderOption;
        String usrOption;
        String phoneNumber = "";
        String email = "";
        String password;
        String confirmPassword;
        String loginUserName;
        String loginPassword;
        String  accountCreationDate;
        int dayOfBirthInt;
        int monthOfBirthInt;
        int yearOfBirthInt;
        LocalDate tempDateOfBirth;
        
        try (Scanner scan = new Scanner(System.in)) {
            int selectedOption;

            System.out.println("Welcome to Fake Bank merchants\n\n");
            System.out.println("Please choose a category you fall under to continue:");
            System.out.println("\n 1. I'm a new customer(I want to create a new bank account)");
            System.out.println("\n 2. I already have a Fake Bank account(I want to login)");
            System.out.println("\n 3. I want to exit the app) \n");

            selectedOption = scan.nextInt();
           
            if(selectedOption == 1) {
               
                while(flag) {

                    System.out.println("======CREATING A NEW BANK ACCOUNT=====");
                    System.out.println("\n\n");
                    System.out.println("Important rules to remember: \n");
                    System.out.println("**All Fields Marked With (**Required) MUST Be Filled-in. \n");
                    System.out.println("**All Fields Marked With(**Optional) can be ignored by typing in n/a. \n"); 
                    System.out.println("**For username use an email address but if you have none use a phone number. \n");
                    System.out.println("**Password contain at least 8 characters, at least one uppercase and special character. \n");
                    System.out.println("**You must be between 16 and 65 years old to open an account. \n");

                    System.out.println("******personal details****** \n");
                    System.out.print("\n 1. Enter your first name(**Required): ");
                    firstName = scan.next();

                    System.out.print("\n 2. Enter your Middle name(**Optional): ");
                    middleName = scan.next();

                    System.out.print("\n 3. Enter your surname(**Required): ");
                    surname = scan.next();

                    System.out.print("\n 4. Date-Of-Birth:");
                    System.out.print("\n\t 4.1. Enter the year you were born in(**Required): ");
                    yearOfBirth =scan.next();
                    
                    System.out.print("\n\n\t 4.2. Type in the number of the month you were born in(e.g 1 - for January) (**Required): ");
                    System.out.print("\n\t 1. JANUARY \n\t 2. FEBRUARY \n\t 3. MARCH \n\t 4. APRIL \n\t 5. MAY \n\t 6. JUNE");
                    System.out.print("\n\t 7. JULY \n\t 8. AUGUST \n\t 9. SEPTEMBER \n\t 10. OCTOBER");
                    System.out.print("\n\t 11. NOVEMBER \n\t 12. DECEMBER \n");
                    usrOption = scan.next();

                    switch(usrOption) {
                        case "1": monthOfBirth = "1"; break;
                        case "2": monthOfBirth = "2"; break;
                        case "3": monthOfBirth = "3"; break;
                        case "4": monthOfBirth = "4"; break;
                        case "5": monthOfBirth = "5"; break;
                        case "6": monthOfBirth = "6"; break;
                        case "7": monthOfBirth = "7"; break;
                        case "8": monthOfBirth = "8"; break;
                        case "9": monthOfBirth = "9"; break;
                        case "10" : monthOfBirth = "10"; break;
                        case "11": monthOfBirth = "11"; break;
                        case "12" : monthOfBirth = "12"; break;
                        default: monthOfBirth = ""; break;
                    }

                    System.out.print("\n\n\t 4.3. Enter the day you were born in (between 1 and 31) (**Required): ");
                    System.out.println("\n ");
                    dayOfBirth = scan.next();
                
                    System.out.print("\n\n 5. Gender - select your gender(**Required):");
                    System.out.print("\n\n\t 5.1. Female");
                    System.out.println("\n\n\t 5.2. Male \n");
                    genderOption = scan.next();

                        if(genderOption.equals("1")) gender = "Female";
                        else if(genderOption.equals("2")) gender = "Male";
                        else gender = "";
                
                System.out.println("\n ******Profile setup******\n");        
                System.out.print("\n\n 6. Enter your cellphone number(**Required): ");
                phoneNumber = scan.next();
                
                System.out.print("\n Enter your email address(**optional): ");
                email = scan.next();

                System.out.print("\n Enter password(**Required): ");
                password = scan.next();
                
                System.out.print("\n Please re-enter password to confirm: ");
                confirmPassword = scan.next();

                if(!(password.equals(confirmPassword))) password = "";
                else password = confirmPassword;
                
                System.out.println("\n\n");
                System.out.println("Checking your input for errors.... \n");
                
                checkAllInputs = UserInputValidator.allInputsOk(firstName, middleName,surname,yearOfBirth,monthOfBirth,dayOfBirth,
                                                                     gender,phoneNumber, email, password);

                //all inputs ok
                if(checkAllInputs) {
                    System.out.println("\n *********************************************");
                    System.out.println("\n All your input values are OK...no errors found " );
                    System.out.println("\n ********************************************* ");

                    dateOfBirth = dayOfBirth + "-" + monthOfBirth + "-" + yearOfBirth;

                    System.out.println("\n ******Are these details correct?****** \n");
                    System.out.println("\n First Name: " + firstName);
                    System.out.println("\n Middle Name: " + middleName);
                    System.out.println("\n Surname: " + surname);
                    System.out.println("\n Gender: " + gender);
                    System.out.println("\n Date-of-birth: " + dateOfBirth);
                    System.out.println("\n Cellphone Numbers: " + phoneNumber);
                    System.out.println("\n Email address: " + email);
                    System.out.println("\n Password: " + password);
                    System.out.println("\n 1. Yes \n 2. No(Fix them) \n");

                    usrOption = scan.next();

                    //no need for else block, because the logic caters for it implicitly
                    if(usrOption.equals("1")) {
                        System.out.println("*".repeat(136));
                        System.out.println("\n Doing some final checks....DONE\n");

                        dayOfBirthInt = Integer.parseInt(dayOfBirth);
                        monthOfBirthInt = Integer.parseInt(monthOfBirth);
                        yearOfBirthInt = Integer.parseInt(yearOfBirth);
                        tempDateOfBirth = LocalDate.of(yearOfBirthInt, monthOfBirthInt, dayOfBirthInt);
                        checkAge = UserInputValidator.isAgeValid(tempDateOfBirth);

                        if(checkAge) {
                            System.out.println("Now Creating your account...");
                            System.out.println("*".repeat(136));
                            Customer newCustomer = new Customer();
                            newCustomer.setFirstName(firstName);
                            newCustomer.setMiddleName(middleName);
                            newCustomer.setSurname(surname);
                            newCustomer.setDateOfBirth(dateOfBirth);
                            newCustomer.setGender(gender);
                            newCustomer.setPhoneNumber(phoneNumber);
                            newCustomer.setEmail(email);
                            newCustomer.setPassword(password);

                            CustomerDAO.insertCustomer(newCustomer);
                            
                            Account account = new Account();
                            account.createAccountNumber(newCustomer.getCustomerId());
                            accountCreationDate = LocalDateTime.now().toString();
                            account.setWhenAccountCreated(accountCreationDate);

                            AccountDAO.createAccount(account, newCustomer);
                            
                            System.out.println("Done creating account! Your new account details: \n");
                            System.out.println("account number: " + account.getAccountNumber());
                            System.out.println("\n Current balance R " + account.getBalance());
                            System.out.println("Date created: " + account.getWhenAccountCreated());

                            System.out.println("\n You can now do the following transactions \n");
                            usrOption = MenuHelper.displayTransactionMenu();

                            switch(usrOption) {
                                case "1":
                                    MenuHelper.depositTransactionHandler(account);   
                                    break;                                                
                                case "2":
                                    MenuHelper.withdrawalTransactionHandler(account);
                                   break;

                                case "3":
                                    MenuHelper.transferTransactionHandler(account);
                                    break;
                                case "4":
                                    MenuHelper.displayAccountProfile(newCustomer, account);
                                    break;
                                case "5":
                                    MenuHelper.signOutHandler();
                                    flag = false;
                                    break;
                                default:
                                     System.out.println("\n\n The option you have selected is not on the **MENU*...try again\n\n");
                                     break;
                            }

                        } else {
                            System.out.println(" \n Failed to create an account for you. Reason(s):" +
                                              " You must be between the ages of 16 and 65 to qualify for " +
                                              "a fake merchants bank account \n");
                            System.out.println("*".repeat(136));
                        }
                        
                        flag = false;
                    }
                } //end of input validation if
                else {
                    System.out.println("\n Some errors were found... ");
                    System.out.println("*".repeat(130));
                    System.out.format("Fields %70s | Outcome", "");
                    System.out.println("");
                    System.out.println("*".repeat(130));
                    System.out.format("\n\n First Name %86s ", UserInputValidator.firstNameError()); 
                    System.out.format("\n Middle Name %86s ", UserInputValidator.middleNameError()); 
                    System.out.format("\n surname %86s ",UserInputValidator.surnameError()); 
                    System.out.format("\n Date-of-birth %86s ", UserInputValidator.dateOfBirthError()); 
                    System.out.format("\n Gender %91s ", UserInputValidator.genderError()); 
                    System.out.format("\n Phone number %86s(%s) ", UserInputValidator.phoneError(), UserInputValidator.phoneRegistrationError()); 
                    System.out.format("\n Email %86s (%s)", UserInputValidator.emailError(), UserInputValidator.emailRegistrationError()); 
                    System.out.format("\n Password %95s ", UserInputValidator.passwordError()); 
                    System.out.println("\n\n Do you want to fix them? \n 1. Yes \n 2. No(Cancel)");
                    usrOption = scan.next();
                    
                    if(usrOption.equals("1")) continue;
                    else if(usrOption.equals("2")) flag = false;
                    System.out.println("\n ********************************************* \n");
                }
        } 
            } 
            
            else if(selectedOption == 2) {
                //login logic
                flag = true;

                while(flag) {
                    System.out.println("\n############# PLEASE ENTER YOUR LOGIN DETAILS #############\n");
                    System.out.print("Enter your username(email/phone number): ");
                    loginUserName = scan.next();

                    System.out.print("Enter your password: ");
                    loginPassword = scan.next();

                    Customer customer = CustomerDAO.getCustomer(loginUserName);

                    if (customer != null) {

                            if ((loginUserName.equals(customer.getEmail())) ||
                                (loginUserName.equals(customer.getPhoneNumber())) ||
                                (loginPassword.equals(customer.getPassword()))) {

                                    System.out.println("*********************************************");
                                    System.out.println("\n Login Was Successful!\n");
                                    System.out.println("Welcome " + customer.getFirstName() + " " + customer.getSurname());

                                   /*
                                    * Code below is a bit messy - i will clean-up soon. To make code more resilient,
                                    * more robust, mantainable by using design patterns and other software engineering 
                                    * techniques
                                    */
                                    Account account = AccountDAO.selectAll(customer.getCustomerId());

                                    System.out.println("customerId= " + customer.getCustomerId());
                                    if(account != null) {

                                    System.out.println("*********************************************");
                                    System.out.println("\n Select a transaction to continue: \n");

                                    usrOption = MenuHelper.displayTransactionMenu();

                                    switch(usrOption) {
                                        case "1":
                                            MenuHelper.depositTransactionHandler(account);   
                                            break;                                                
                                        case "2":
                                            MenuHelper.withdrawalTransactionHandler(account);
                                           break;

                                        case "3":
                                            MenuHelper.transferTransactionHandler(account);
                                            break;
                                        case "4":
                                            MenuHelper.displayAccountProfile(customer, account);
                                            break;
                                        case "5":
                                            MenuHelper.signOutHandler();
                                            flag = false;
                                            break;
                                        default:
                                            System.out.println("\n\n The option you have selected is not on the **MENU*...try again\n\n");
                                            break;
                                        
                                    }
                                } else System.out.println("\n could not get account");
                                    
                        } else {
                            System.out.println("\n\n");
                            System.out.println("\n Incorrect username or password \n 1. Try again \n 2. Exit login \n");
                            usrOption = scan.next();
    
                            if(usrOption.equals("1")) continue;
                            else if(usrOption.equals("2")) flag = false;
                        }
                        //end of null check if
                    } else System.out.println("\n No such account exists! Select 'Exit login' and " +
                                                "then create a new account(if you are a new customer)  \n");
            }//end of while

            } else {
                //exit logic
                System.out.println("\n Thank you for using the Fake Bank Merchants app...see you soon! \n");
            }
        }
    }

  
}
