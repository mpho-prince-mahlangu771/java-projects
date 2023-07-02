import java.time.LocalDate;
import java.time.LocalTime;

public class BankAccount {
    
    private String accountNumber; //autogenerate with database
    private double balance;
    private String customerID; //get from customerclass or database
    private LocalDate dateCreated;
    private LocalTime timeCreated;

    public BankAccount(String customerID) {
        this.balance = 0; //default
        this.dateCreated = LocalDate.now();
        this.timeCreated = LocalTime.now();
        this.customerID = customerID;

    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void updateBalance(double balance) {
        this.balance = balance;
    }
    public String getCustomerID() {
        return customerID;
    }
    public LocalDate getDateCreated() {
        return dateCreated;
    }
    /*
     * account number algorithm:
     * customer #(1,2,etc) + year+month+day+3random numbers
     */

     
    
}
