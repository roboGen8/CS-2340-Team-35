package com.example.ben.cs2340.model;

public class Accounts {

    private String _name;

    private String _username;

    private String _password;

    private Credentials _credentials;

    public Account(String name, String username, String password, Credentials credentials) {
        _name = name;
        _username = username;
        _password = password;
        _credentials = credentials;
    }
}
