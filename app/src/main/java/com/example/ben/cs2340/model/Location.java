package com.example.ben.cs2340.model;

public class Location {

    String _name;
    float _latitude;
    float _longitude;
    String _address;
    String _city;
    String _state;
    String _zip;
    String _type;
    String _phone;
    String _website;

    public Location(String name, float latitude, float longitude, String address, String city, String state, String zip, String type, String phone, String website) {
        _name = name;
        _latitude = latitude;
        _longitude = longitude;
        _address = address;
        _city = city;
        _state = state;
        _zip = zip;
        _type = type;
        _phone = phone;
        _website = website;
    }

}
