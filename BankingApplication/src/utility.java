import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utility {
    public static int displayWelcomeMessage() {
        int selectedOption = 0;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Welcome to Fake Bank merchants\n\n");
            System.out.println("Please choose a category you fall under to continue:");
            System.out.println("\n 1. I'm a new customer(I want to create a new bank account)");
            System.out.println("\n 2. I already have a Fake Bank account(I want to login)\n");
            System.out.println("\n 3. I want to exit the app) \n");

            selectedOption = scan.nextInt();
            
            if(selectedOption == 1) return 1;
            else if(selectedOption == 2) return 2;
            else if(selectedOption == 3) return 3;
    
            return selectedOption;
        }


    }

}
