package com.example.ben.cs2340.model;

public class Accounts {

    private String _name;

    private String _username;

    private String _password;

    private Credentials _credentials;

    public Accounts(String name, String username, String password, Credentials credentials) {
        _name = name;
        _username = username;
        _password = password;
        _credentials = credentials;
    }

    public String getName(){
        return _name;
    }
    public void setName(String name) {
        _name = name;
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

    public Credentials getCredentials() {
        return _credentials;
    }
    public void setCredentials(Credentials credentials) {
        _credentials = credentials;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return ((Accounts) obj).getUsername().equals(this.getUsername());
    }
    @Override
    public String toString() {
        return _username;
    }
}