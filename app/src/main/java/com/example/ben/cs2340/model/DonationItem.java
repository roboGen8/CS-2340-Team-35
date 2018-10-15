package com.example.ben.cs2340.model;

public class DonationItem {

    private String _timeStamp;
    private String _location;
    private String _shortDescription;
    private String _fullDescription;
    private double _value;
    private String _category;

    public DonationItem(String _timeStamp, String _location, String _shortDescription, String _fullDescription, double _value, String _category) {
        this._timeStamp = _timeStamp;
        this._location = _location;
        this._shortDescription = _shortDescription;
        this._fullDescription = _fullDescription;
        this._value = _value;
        this._category = _category;
    }

    public String getTimeStamp() {
        return _timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        _timeStamp = timeStamp;
    }

    public String getLocation() {
        return _location;
    }
    public void setLocation(String _location) {
        this._location = _location;
    }

    public String getShortDescription() {
        return _shortDescription;
    }
    public void setShortDescription(String _shortDescription) {
        this._shortDescription = _shortDescription;
    }

    public String getFullDescription() {
        return _fullDescription;
    }
    public void setFullDescription(String _fullDescription) {
        this._fullDescription = _fullDescription;
    }

    public double getValue() {
        return _value;
    }
    public void setValue(double _value) {
        this._value = _value;
    }

    public String getCategory() {
        return _category;
    }
    public void setCategory(String _category) {
        this._category = _category;
    }
}
