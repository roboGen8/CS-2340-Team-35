package com.example.ben.cs2340.model;

import android.util.Log;

public class LoginService {
    /**  the one and only instance of this class for the singleton pattern */
    private static LoginService INSTANCE = new LoginService();
    /** remember the currently logged in account.  null == there is no logged in person */
    private Account currentAccount = null;

    /**
     * This is the singleton pattern accessor.  Call this to get the instance of this class
     * @return  the one instance of the facade
     */
    public static LoginService getInstance() { return INSTANCE; }

    /**  the class that manages all the users */
    private AccountManager _accountManager;

    /**
     *   Private constructor since this is a singleton.
     */
    private LoginService() {
        _accountManager = new AccountManager();
    }

    /**
     * Call this method to get the currently logged in user, will return
     * a null if there is no one logged in
     *
     * @return  the last logged in user,
     */
    public Account getCurrentAccount() {return currentAccount; }

    /**
     * Handle a Login request,  delegate the action to the actual model classes
     * Sets the current user value if login successful
     * @param username  the user id of the person trying to log in
     * @param password  the password of the person trying to log in
     * @return  true if login success, false otherwise
     */
    public boolean doLogin(String username, String password) {
        //don't do anything if someone is already logged in
        if (hasLoggedInUser()) return false;
        //get the user from the model
        Account account = _accountManager.checkLogin(username, password);
        //check for success
        if (account != null) {
            currentAccount = account;
            Log.d("aaa", "Set current user to :" + account);
            return true;
        }
        return false;
    }

    /**
     * Call this method for logout, which sets the currentUser to null
     */
    public void logout() {
        currentAccount = null;
    }

    /**
     * Call this method to check if anyone is logged in
     */
    public boolean hasLoggedInUser() { return currentAccount != null; }
}
