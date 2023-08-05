package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.Customer;
import com.mycompany.UserInputValidator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * TODO - write test for deposit transaction
     * test cases - amount below 5.00 
     */
    private Customer customer = new Customer();
    private boolean checkInputs;

    @Before
    public void createCustomer()
    {
        customer.setFirstName("Tshepo");
        customer.setMiddleName("Bafana");
        customer.setSurname("magagula");
        customer.setYearOfBirth("2014");
        customer.setMonthOfBirth("6");
        customer.setDayOfBirth("21");
        customer.setGender("male");
        customer.setPhoneNumber("0733733319");
        customer.setEmail("mfanas@gmail.com");
        customer.setPassword("sonofmavankis909");
    }

    @Test
    public void testAllInputs() {
        checkInputs = UserInputValidator.allInputsOk(customer.getFirstName(), customer.getMiddleName(), customer.getSurname(),
                                         customer.getYearOfBirth(),customer.getMonthOfBirth(), customer.getDayOfBirth(),
                                         customer.getGender(), customer.getPhoneNumber(), customer.getEmail(),
                                         customer.getPassword());
    
        assertTrue("some inputs got errors", checkInputs);                                         
    }

    //fails if does not exist
    @Test
    public void testPhoneRegistrationMethod(){
        boolean phoneRegistered = UserInputValidator.isPhoneRegistered(customer.getPhoneNumber());
        assertTrue("phone number does not exist in the customers database", phoneRegistered);
    }

    @Test
    public void testEmailRegistrationMethod(){
        boolean emailRegistered = UserInputValidator.isEmailRegistered(customer.getEmail());
        assertTrue("Email does not exist in the customers database", emailRegistered);
    }

    /*
     * 
     */
    @Test
    public void testDeposit() {
        /*
         * A user can enter any of the f.f inputs when depositing money:
         * a string e.g. - abc/ &njnm
         * a string with a num e.g - R5.00
         * an amount below 5.00 
         * a valid amount - amount >= 5.00
         */
    }
}
