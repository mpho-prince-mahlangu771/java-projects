import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName = "";
    private String middleName;
    String surname;
    String dateOfBirth;
    int yearOfBirth;
    int monthOfBirth;
    public int getMonthOfBirth() {
        return monthOfBirth;
    }
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }
    int dayOfBirth;
    private String gender; // fix: make as enum
    private String cellphoneNumber;
    private String email;
    private String password;
    private String comfirmPassword;
    
    public Customer() {}
    public Customer(String firstName, String surname, String dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSurname() {
        return surname;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
    public String getComfirmPassword() {
        return comfirmPassword;
    }
    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public int getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }


    
    

   


}
