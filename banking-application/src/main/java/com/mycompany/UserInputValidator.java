package com.mycompany;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    public static boolean validateInput( String firstName, String middleName, String surname,
                                    String yearOfBirth, String monthOfBirth, String dayOfBirth,
                                    String gender, String cellPhoneNumber, String email, String password ) {

        Pattern nameRegex = Pattern.compile("[a-zA-Z]+");
        Pattern emailRegex = Pattern.compile("^(\\w)+@[a-zA-Z]+.[a-zA-Z]+");
        Pattern cellPhoneNumerRegex = Pattern.compile("^0\\d{9}");
        Pattern yearOfBirthRegex = Pattern.compile("\\d{4}");
        Pattern dayMonthRegex = Pattern.compile("\\d{1,2}");
        Pattern passwordRegex = Pattern.compile("\\w{8,}"); //to be fixed(incomplete regex)

        Matcher firstNameMatcher = nameRegex.matcher(firstName);
        Matcher middleNameMatcher = nameRegex.matcher(middleName);
        Matcher surnameMatcher = nameRegex.matcher(surname);
        Matcher emailMatcher = emailRegex.matcher(email);
        Matcher cellPhoneNumberMatcher = cellPhoneNumerRegex.matcher(cellPhoneNumber);
        Matcher dayOfBirthMatcher = dayMonthRegex.matcher(dayOfBirth);
        Matcher monthOfBirthMatcher = dayMonthRegex.matcher(monthOfBirth);
        Matcher yearOfBirthMatcher = yearOfBirthRegex.matcher(yearOfBirth);
        Matcher passwordMatcher = passwordRegex.matcher(password);
        
        
        //some input is in an invalid format
        if(firstNameMatcher.matches() && middleNameMatcher.matches() && 
        surnameMatcher.matches() && dayOfBirthMatcher.matches() &&
        monthOfBirthMatcher.matches() && yearOfBirthMatcher.matches() &&
        cellPhoneNumberMatcher.matches() && emailMatcher.matches() &&
        passwordMatcher.matches() && !(gender.isBlank())) {

            return true;
        }

         return false;
    }
}
