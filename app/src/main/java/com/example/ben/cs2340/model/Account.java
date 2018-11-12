package com.example.ben.cs2340.model;

public class Account {

    private String _name;
    private String _username;
    private String _password;
    private Credentials _credentials;

    public Account() {
        // Default constructor required for calls to Firebase
    }

    public Account(String username, String password, String name, Credentials credentials) {
        _username = username;
        _password = password;
        _name = name;
        _credentials = credentials;
    }

    public String getUsername() {
        return _username;
    }
    public void setUsername(String username) {
        _username = username;
    }

    public String getPassword() {
        return _password;
    }
    public void setPassword(String password) {
        _password = password;
    }

    public String getName(){
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    public Credentials getCredentials() {
        return _credentials;
    }
    public void setCredentials(Credentials credentials) {
        _credentials = credentials;
    }

    public boolean checkPassword(String pass) {return _password.equals(pass);}

    public boolean isValid() {
        boolean res = true;
        if (_username == null || _password == null || _name == null || _credentials == null) {
            res = false;
        }
        return res;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return ((Account) obj).getUsername().equals(this.getUsername());
    }
    @Override
    public String toString() {
        return _username;
    }
}