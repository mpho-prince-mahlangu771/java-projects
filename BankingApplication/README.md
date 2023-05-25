# System Analysis

Elements: <br>
1. Requirement specifications <br>
2. Use cases <br>
3.  Data modelling(ERD - entity relational diagrams) <br>


## Requirement specification

1. A user shall be able to deposit money into their own account(s) <br>
2. A user shall be able to withdraw money from their own account(s) <br>
3. A user shall be able to tranfer money between their own accounts - e.g.  from savings account to fixed account , vice versa<br>
4. A user shall be able to transfer money from their account(s) into another,  external account - aka pay another person <br>

## Use cases: 
<br>

USE CASE NO  1 <br><br>

Use case name: Create a bank account <br>
Actor: customer <br> 
Description: New customer creates a bank account<br>
Trigger: Customer clicks create bank account button<br> 
Pre-conditions: <br>
    1. Customer is not under 18 years old <br>

Normal course: <br>
1.0. Create bank account  <br>
1. The customer enters into the application portal<br> 
2. The customer enters their personal details<br>
3. The system determines the age of the customer <br>
4. The customers application is approved <br>

Alternate case: <br>
1.1. Customer is under aged <br>
1. The system prompts the customer that they are under the age of 18<br>
2. The system terminates the use case <br>

Post-conditions: <br>
1. A bank account is created

<br>
USE CASE NO 2 <br> <br>

Use case name: Deposit money into account <br>
Actor: Customer <br>
Description: A customer wants to deposit x amount into any one of their own account <br>
Trigger: Depost button has been clicked <br>
Pre-conditions: <br>
    1. Customer has a bank acount with the bank <br>
    2. Customer has an account number <br>

Normal course:  <br>
1.0 <br>
1. Customer clicks the deposit button <br>
2. The system prompts the customer to enter the account number they want to deposit to <br>
3. The customer enters the account number <br>
4. The system prompts the customer to enter the amount they wish to deposit <br>
5. The customer enters the amount <br>
6. The system prompts customer to confirm deposit details <br>
7. The customer confirms details and clicks the submit button <br>
8. The system processes the request and terminates the use case<br>

Post-conditions: <br>
    1. Money is deposited into bank account <br>
    2. Bank Balance is updated <br>

Exceptions: <br>
E1: Account number is invalid <br>
1. System prompts customer to enter a valid account number  or cancel request<br>
1a. customer enters valid account number - use case returns to normal course - step 4 <br>
1b. customer cancels request - use case is terminated.


USE CASE NO  3 <br> <br>

Use case name: Withdraw money <br>
Actors: Customer <br>
Description: Customer wants to withdraw x amount from their bank account <br>
Trigger: The withdraw button has been clicked <br>
Pre-conditions: <br>
    1. Customer has a bank account <br>
    2. Bank account to withdraw from has minimum amount of money <br>

Normal course: <br>
1.0. Request a money withdrawal <br>
1. The customer clicks the withdraw button <br>
2. The system displays accounts belonging to customer. <br> 
3. The system prompts customer to select an account from step 2 to withdraw from <br>
4. The customer selects an account <br>
5. The system prompts the customer to enter the amount they wish to withdraw <br>
6. The customer enters the amount <br>
7. The system subtracts the withdrawal amount from the accounht bank balance and issues out the money to the customer <br>
8. The system terminates the use case <br>

Alternate course: <br>
1.1. Insufficient balance <br>
1. The customer enters a withdrawal amount greater than the account balance <br>
2. The system prompts  customer to enter an amount less than or equal to the bank account balance  or cancel the request <br>
3. The customer enters a valid amount <br>
4. The system continues with the normal course - step 7 <br>

Post-condition:  <br>
    1. Withdrawal is approved <br>
    2. Account balance is updated<br> <br>


USE CASE NO 4 <br> <br>


Use case name: Transfer money <br>
Actor: Customer <br>
Description: Customer transfers money from one account(self or external) to another <br>
Triggers: Transfer button has been clicked <br>
Pre-conditions: <br>
    1. Sender(Customer) has a back account <br>
    2. Recepient has a bank account <br>
    3. Sender's bank account has sufficient funds <br>

Normal course: <br>
1.0. Transfer funds <br>
1. The customer clicks the transfer button <br>
2. The system prompts the customer to enter the account number of the recepient <br>
3. The customer enters their account number <br>
4. The system prompts the customer to enter the amount they wish to transfer <br>
5. The customer enters the amount <br>
6. The system subtracts the amount from the customers bank balance <br>
7. The system transfers the money to the recepient <br>

Alternate course: <br>
1.1. Insufficient balance <br>
1. The customer enters a withdrawal amount greater than the account balance <br>
2. The system prompts  customer to enter an amount less than or equal to the bank account balance  or cancel the request <br>
3. The customer enters a valid amount <br>
4. The system continues with the normal course - step 7 <br>

Exceptions: <br>
E1: Account number is invalid <br>
1. System prompts customer to enter a valid account number  or cancel request<br>
1a. customer enters valid account number - use case returns to normal course - step 4<br>
1b. customer cancels request - use case is terminated. <br>

Post-condition: <br>
   1. Money is deposited into recepient's bank account <br>
   2. Customer's(sender) Bank Balance is updated <br>