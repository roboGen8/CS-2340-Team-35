package com.example.ben.cs2340.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robertwaters on 2/22/18.
 *
 * <<Structurer>>
 * This class holds all the known users for the app.  It allows for searching for a user
 * and performing valid actions on users like login.
 *
 */

public class AccountManager {
    /** the map of current users  Key = username  Value = Account object */
    private Map<String, Account> _accounts;

    /**
     * Adds a user to the map of known users
     * Accountname must be unique, so if you try to add the same username, add will fail
     *
     * @param username  the user id of the new user
     * @param password  the password of the new user
     * @param name  the name of the new user
     * @return  true if add was successful, false otherwise
     */

    public boolean addAccount(String username, String password, String name, Credentials credentials) {

        Account account = new Account(username, password, name, credentials);

        //check that username is not already in collection
        if (_accounts.containsKey(username)) return false;

        _accounts.put(username, account);
        return true;
    }

    /**
     * Check for a successful login by looking up the user and checking their password.
     *
     * @param username  the login user id
     * @param password  the login password
     * @return Account object if successful, null otherwise
     */
    public Account checkLogin(String username, String password) {
        Account account = null;
        if (_accounts.containsKey(username)) {
            account = _accounts.get(username);

            if (account.checkPassword(password)) {
                return account;
            }
            return null;
        } else {
            return null;
        }

    }

    /**
     * Constructs a new object
     * Currently adds a dummy account, remove that when registration is implemented!
     */
    public AccountManager() {
        _accounts = new HashMap<>();
        addAccount("user", "pass", "George Burdell", Credentials.USER);
    }
}
