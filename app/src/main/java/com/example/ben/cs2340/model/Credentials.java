package com.example.ben.cs2340.model;

public enum Credentials {
    USER ("User"),
    EMPLOYEE ("Employee"),
    MANAGER ("Manager"),
    ADMINISTRATOR ("Administrator");

    private final String name;

    Credentials(String pname) {
        name = pname;
    }
}
