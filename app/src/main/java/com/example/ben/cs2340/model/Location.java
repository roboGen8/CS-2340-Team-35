package com.example.ben.cs2340.model;

public class Location {

    private String _name;
    private float _latitude;
    private float _longitude;
    private String _address;
    private String _city;
    private String _state;
    private String _zip;
    private String _type;
    private String _phone;
    private String _website;

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

    public String get_name() {
        return _name;
    }

    public float get_latitude() {
        return _latitude;
    }
    public void set_latitude(float latitude){
        _latitude = latitude;
    }
}
