package com.example.ben.cs2340;

import com.example.ben.cs2340.model.Account;
import com.example.ben.cs2340.model.Credentials;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;

public class BrianUnitTest {
    private String validUN = "Brian";
    private String validPass = "Chea";
    private String validName = "Tang";
    private Credentials validAdmin = Credentials.ADMINISTRATOR;
    private Credentials validEmp = Credentials.EMPLOYEE;
    private Credentials validMan = Credentials.MANAGER;
    private Credentials validUser = Credentials.USER;

    Account validAcc1 = new Account(validUN, validPass, validName, validAdmin);
    Account emptyAcc1 = new Account();
    Account validAcc2 = new Account(validUN, validPass, validName, validAdmin);

    //checks if account using all parameters in constructor is valid
    @Test
    public void val1() {
        assertEquals(true, validAcc1.isValid());
    }

    //checks if account using no arg constructor is invalid
    @Test
    public void emptyAcc() {
        assertEquals(false, emptyAcc1.isValid());
    }

    //checks if account is invalid until all parameters are filled
    @Test
    public void addInfo() {
        emptyAcc1.setName("Brian");
        assertEquals(false, emptyAcc1.isValid());
        emptyAcc1.setUsername("Brian");
        assertEquals(false, emptyAcc1.isValid());
        emptyAcc1.setPassword("Brian");
        assertEquals(false, emptyAcc1.isValid());
        emptyAcc1.setCredentials(validAdmin);
        assertEquals(true, emptyAcc1.isValid());
    }

    //checks if setting null invalidates account
    @Test
    public void invalidateAcc() {
        validAcc1.setPassword(null);
        assertEquals(false, validAcc1.isValid());
    }

    //checks if adding the value back it revalidates account
    @Test
    public void revalidateAcc() {
        validAcc1.setPassword("1234");
        assertEquals(true, validAcc1.isValid());
    }

    @Test
    public void val2() {
        assertEquals(true, validAcc2.isValid());
    }

    //checks if editing info invalidates account
    @Test
    public void editName() {
        validAcc2.setName("Andy");
        assertEquals(true, validAcc2.isValid());
        validAcc2.setUsername("Andy");
        assertEquals(true, validAcc2.isValid());
        validAcc2.setPassword("Andy");
        assertEquals(true, validAcc2.isValid());
        validAcc2.setCredentials(validEmp);
        assertEquals(true, validAcc2.isValid());
    }

}
