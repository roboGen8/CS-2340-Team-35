package com.example.ben.cs2340;

import com.example.ben.cs2340.model.Account;
import com.example.ben.cs2340.model.Credentials;

import org.junit.Before;
import org.junit.Test;


import static com.example.ben.cs2340.model.Credentials.USER;
import static org.junit.Assert.*;

public class LilyUnitTest {
    private Account testAccount;
    private Account testAccount2;
    @Before
    public void setUp() {
        testAccount =   new Account("lily", "pass", "Lily", USER);
        testAccount2 = new Account("lilly", "pass", "Lilly", USER);
    }

    @Test
    public void equals_isCorrect() { assertEquals(true, testAccount.equals(testAccount)); }

    @Test
    public void equals_isFalse() { assertEquals(false, testAccount.equals(testAccount2));}
}
