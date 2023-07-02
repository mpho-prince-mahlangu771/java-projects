import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) throws Exception {
        String firstName;
        String middleName; //optional
        String surname;
        LocalDate dateOfBirth;
        String yearOfBirth;
        String monthOfBirth;
        String dayOfBirth;
        String gender;
        String genderOption;
        String usrOption;
        String cellphoneNumber;
        String email;
        String password;
        String confirmPassword;
        boolean flag = true;
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
                    System.out.println("******personal details****** \n");
                    System.out.print("\n 1. Enter your first name: ");
                    firstName = scan.next();

                    System.out.print("\n 2. Enter your Middle name: ");
                    middleName = scan.next();

                    System.out.print("\n 3. Enter your surname: ");
                    surname = scan.next();

                    System.out.print("\n 4. Date-Of-Birth:");
                    System.out.print("\n\t 4.1. Enter the year you were born in: ");
                    yearOfBirth =scan.next();
                    
                    System.out.print("\n\n\t 4.2. Enter the month you were born in: ");
                    monthOfBirth = scan.next();

                    System.out.print("\n\n\t 4.3. Enter the day you were born in: ");
                    dayOfBirth = scan.next();
                
                    System.out.print("\n\n 5. Gender - select your gender:");
                    System.out.print("\n\n\t 5.1. Female");
                    System.out.println("\n\n\t 5.2. Male \n");
                    genderOption = scan.next();

                        if(genderOption.equals("1")) gender = "Female";
                        else if(genderOption.equals("2")) gender = "Male";
                        else gender = "";
                
                System.out.println("\n ******Profile setup******\n");        
                System.out.print("\n\n 6. Enter your cellphone number: ");
                cellphoneNumber = scan.next();
                
                System.out.print("\n Enter your email address: ");
                email = scan.next();

                System.out.print("\n Enter password: ");
                password = scan.next();
                
                System.out.print("\n Please re-enter password to confirm: ");
                confirmPassword = scan.next();

                if(!(password.equals(confirmPassword))) password = "";
                
                System.out.println("\n\n");
                System.out.println("Checking your input for errors.... \n");

                boolean isInputValid = UserInputValidator.validateInput(firstName, middleName, surname, yearOfBirth,
                                                                monthOfBirth, dayOfBirth, gender, cellphoneNumber, 
                                                                email, password);

                if(isInputValid) {
                    System.out.println("\n *********************************************");
                    System.out.println("\n All your input values are OK...no errors found " );
                    System.out.println("\n ********************************************* \n");

                    int dayOfBirthInt = Integer.parseInt(dayOfBirth);
                    int monthOfBirthInt = Integer.parseInt(monthOfBirth);
                    int yearOfBirthInt = Integer.parseInt(yearOfBirth);

                    dateOfBirth = LocalDate.of(yearOfBirthInt, monthOfBirthInt, dayOfBirthInt);

                    System.out.println("\n ******Are these details correct?****** \n");
                    System.out.println("\n First Name: " + firstName);
                    System.out.println("\n Middle Name: " + middleName);
                    System.out.println("\n Surname: " + surname);
                    System.out.println("\n Gender: " + gender);
                    System.out.println("\n Date-of-birth: " + dateOfBirth);
                    System.out.println("\n Cellphone Numbers: " + cellphoneNumber);
                    System.out.println("\n Email address: " + email);
                    System.out.println("\n Password: " + password);
                    System.out.println("\n \n 1. Yes \n 2. No(Fix them) \n");

                    usrOption = scan.next();

                    //no need for else block, because the logic caters for it implicitly
                    if(usrOption.equals("1")) {
                        //create customer profile
                        Customer newCustomer = new Customer(firstName, middleName, surname, dayOfBirth,
                                                            monthOfBirth, yearOfBirth, dateOfBirth, gender, 
                                                            cellphoneNumber, email, password);

                        flag = false;
                        //store newcustomer in db - also to generate customerID for the bankAccount class
                        // create and init bank class

                    }
                } //end of input validation if
                else {
                    System.out.println("\n *********************************************");
                    System.out.println("\n Some input values are in an INVALID format...try again? \n 1. Yes \n 2. No(Cancel)");
                    usrOption = scan.next();
                    
                    if(usrOption.equals("1")) continue;
                    else if(usrOption.equals("2")) flag = false;
                    System.out.println("\n ********************************************* \n");
                }
        } 
            } 
            
            else if(selectedOption == 2) {
                //login logic
            } else {
                //exit logic
            }
        }
    }

  
}
