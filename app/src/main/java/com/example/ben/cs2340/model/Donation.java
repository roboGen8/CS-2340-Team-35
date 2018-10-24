package com.example.ben.cs2340.model;

import android.os.Parcelable;

public class Donation implements Parcelable {
    private String _timestamp;
    private Location _location;
    private String _shortDescription;
    private String _longDescription;
    private double _value;
    private DonationCategory _category;
    private String[] _comments;
//    private something _image;

    public Donation(String _timestamp, Location _location, String _shortDescription, String _longDescription, double _value, DonationCategory _category) {
        this._timestamp = _timestamp;
        this._location = _location;
        this._shortDescription = _shortDescription;
        this._longDescription = _longDescription;
        this._value = _value;
        this._category = _category;
    }

    public String get_timestamp() {
        return _timestamp;
    }
    public void set_timestamp(String _timestamp) {
        this._timestamp = _timestamp;
    }

    public Location get_location() {
        return _location;
    }
    public void set_location(Location _location) {
        this._location = _location;
    }

    public String get_shortDescription() {
        return _shortDescription;
    }
    public void set_shortDescription(String _shortDescription) {
        this._shortDescription = _shortDescription;
    }

    public String get_longDescription() {
        return _longDescription;
    }
    public void set_longDescription(String _longDescription) {
        this._longDescription = _longDescription;
    }

    public double get_value() {
        return _value;
    }
    public void set_value(double _value) {
        this._value = _value;
    }

    public DonationCategory get_category() {
        return _category;
    }
    public void set_category(DonationCategory _category) {
        this._category = _category;
    }

    public String[] get_comments() {
        return _comments;
    }
    public void set_comments(String[] _comments) {
        this._comments = _comments;
    }

    @Override
    public int describeContents(){return 0;}
}
