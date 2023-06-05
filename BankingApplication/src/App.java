import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
            int selectedOption = displayWelcomeMessage();

           
            if(selectedOption == 1) {
               //create new customer logic
               createBankAccount(); 
            } else if(selectedOption == 2) {
                //login logic
            } else {
                //exit logic
            }
    }

    public static int displayWelcomeMessage() {
        int selectedOption = 0;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Welcome to Fake Bank merchants\n\n");
            System.out.println("Please choose a category you fall under to continue:");
            System.out.println("\n 1. I'm a new customer(I want to create a new bank account)");
            System.out.println("\n 2. I already have a Fake Bank account(I want to login)\n");
            System.out.println("\n\n 3. Don't care(I want exit) \n");

            selectedOption = scan.nextInt();
        }

        if(selectedOption == 1) return 1;
        else if(selectedOption == 2) return 2;
        else if(selectedOption == 3) return 3;

        return selectedOption;
    }

    public static void createBankAccount() {
        Scanner scan = new Scanner(System.in);
            String firstName;
            String middleName =  ""; //optional
            String surname;
            String dateOfBirth;
            int yearOfBirth;
            int monthOfBirth;
            int dayOfBirth;
            String gender;
            String cellphoneNumber;
            String email;
            String password;
            String confirmPassword;

            System.out.println("\n\n======CREATING A NEW BANK ACCOUNT=====");
            System.out.println("\n\n");
            System.out.println("Step 1 - personal details: ");
            System.out.print("\n 1. Enter your first name: \n");
            // firstName = scan.next();
            System.out.print("\n 2. Enter your Middle name: \n");
            // middleName = scan.nextLine();
            System.out.print("\n 3. Enter your surname: \n");
            // surname = scan.nextLine();
      
        System.out.print("\n 4. Date-Of-Birth:");
        System.out.print("\n\t 4.1. Enter the year you were born in:");
        yearOfBirth = scan.nextInt();
        System.out.print("\n\n\t 4.2. Enter the month you were born in:");
        System.out.print("\n\n\t 4.3. Enter the day you were born in:");
        System.out.print("\n\n 5. Gender - select your gender:");
        System.out.print("\n\n\t 5.1. Female");
        System.out.print("\n\n\t 5.2. Male");
        System.out.print("\n\n 6. Enter your cellphone number:\n");



    }
}
