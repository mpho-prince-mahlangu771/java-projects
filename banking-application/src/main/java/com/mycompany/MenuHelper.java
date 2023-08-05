package com.mycompany;

import java.util.Scanner;

public class MenuHelper {

    private static Scanner scan = new Scanner(System.in);
    private static Boolean checkAccountNumber;
    private static String enteredAmount;
    private static String selectedOption;
    private static String transfereeAccountNumber;
    private static String transfererAccount;
    private static double amountToTransfer;
    private static double withdrawalAmount;
    private static Account account;
    private static Customer customer;

    public static void depositTransactionHandler(Account account) {
        System.out.println("\n\n ####### Deposit Transaction Selected #######\n\n");
        System.out.print("Remember - Any amount below R5.00 is considered invalid and " +
                "as such cannot be deposited...\n ");

        System.out.print("\n Enter The Amount You Want To Deposit OR type-in 00 to cancel the transaction: \n");

        while (!scan.hasNextDouble()) {
            System.out.println("\n Amount you entered is invalid \n");
            scan.next();
        }

        amountToTransfer = scan.nextDouble();

        if (amountToTransfer == 00) {
            displayTransactionMenu();
        }

        else if (amountToTransfer >= 5) {
            account.setBalance(account.getBalance() + amountToTransfer);
            AccountDAO.depositMoney(account.getBalance(), account.getAccountNumber());
            System.out.println("\n\n Deposit transaction was successful! Your **NEW balance is R "
                    + account.getBalance() + " **\n\n");
            displayTransactionMenu();
        } else {
            System.out.println("\n\n You can ONLY deposit starting from R5...any amount below that is invalid \n\n");
        }
    }

    public static void withdrawalTransactionHandler(Account account) {
        System.out.println("\n\n ####### Withdrawal Transaction Selected ####### \n\n");
        System.out.println("\n Remember - ");
        System.out.print("\n Enter the amount want to withdraw: ");

        while (!scan.hasNextDouble()) {
            System.out.println("\n Enter a valid amount \n");
            scan.next();
        }

        withdrawalAmount = scan.nextDouble();
        account.setBalance(account.getBalance() - withdrawalAmount);
        AccountDAO.depositMoney(account.getBalance(), account.getAccountNumber());
        System.out.println("\n\n Withdrawal successful! Your **new balance is R" + account.getBalance() + "**\n\n");
    }

    public static void transferTransactionHandler(Account account) {
        System.out.println("\n\n ####### Transfer Transaction Selected ####### \n\n");
        System.out.print(" Enter the **ACCOUNT NUMBER** of the customer you want to transfer to: ");

        transfereeAccountNumber = scan.next();
        checkAccountNumber = UserInputValidator.isAccountNumberValid(transfereeAccountNumber);

        if (checkAccountNumber) {
            System.out.print("\n\n Enter the **AMOUNT** you want to transfer:  ");
            while (!scan.hasNextDouble()) {
                System.out.println("\n The amount you entered is invalid...try again \n");
                scan.next();
            }

            amountToTransfer = scan.nextDouble();

            if (account.getBalance() >= amountToTransfer) {

                Account transfereeAccount = AccountDAO.getAccount(transfereeAccountNumber);

                transfereeAccount.setBalance(transfereeAccount.getBalance() + amountToTransfer);
                AccountDAO.depositMoney(transfereeAccount.getBalance(), transfereeAccountNumber);

                account.setBalance(account.getBalance() - amountToTransfer);
                AccountDAO.depositMoney(account.getBalance(), account.getAccountNumber());

                System.out.println("Transferer balance = R" + account.getBalance());
                System.out.println("Transferee balance = R" + transfereeAccount.getBalance());

            } else
                System.out.println("TRANSFER FAILED: Insufficient funds...");

        } else
            System.out.println("\n\n The account number you entered is invalid...re-check it and try again \n\n");
    }

    public static void displayAccountProfile(Customer customer, Account account) {
        System.out.println("**************************************");
        System.out.println("\n Here's your profile: ");
        System.out.println("**************************************");
        System.out.println("\n Name: " + customer.getFirstName() + " " + customer.getMiddleName() +
                " " + customer.getSurname());
        System.out.println("\n Date-of-Birth: " + customer.getDateOfBirth());
        System.out.println("\n Gender: " + customer.getGender());
        System.out.println("\n Phone number: " + customer.getPhoneNumber());
        System.out.println("\n Email address: " + customer.getEmail());
        System.out.println("\n Account number: " + account.getAccountNumber());
        System.out.println("\n Created-on: " + account.getWhenAccountCreated());
        System.out.println("\n Current balance R  " + account.getBalance());
        System.out.println("\n");
    }

    public static boolean signOutHandler() {
        System.out.println("\n\n Thank you for using my fake bank application...hope you enjoyed the experience!\n\n");
        return false;
    }

    public static String displayTransactionMenu() {

        System.out.println(" \n 1. Deposit \n 2. Withdraw \n 3. Transfer \n" +
                "4. View your account profile \n 5. Sign-out");

        return selectedOption = scan.next();

    }

}
