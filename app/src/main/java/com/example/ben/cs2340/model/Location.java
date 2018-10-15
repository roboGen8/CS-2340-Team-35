package com.example.ben.cs2340.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable{

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

    protected Location(Parcel in) {
        _name = in.readString();
        _latitude = in.readFloat();
        _longitude = in.readFloat();
        _address = in.readString();
        _city = in.readString();
        _state = in.readString();
        _zip = in.readString();
        _type = in.readString();
        _phone = in.readString();
        _website = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    public float getLatitude() {
        return _latitude;
    }
    public void setLatitude(float latitude){
        _latitude = latitude;
    }

    public float getLongitude() {
        return _longitude;
    }
    public void setLongitude(float longitude) {
        _longitude = longitude;
    }

    public String getAddress() {
        return _address;
    }
    public void setAddress(String address) {
        _address = address;
    }

    public String getCity() {
        return _city;
    }
    public void setCity(String city) {
        _city = city;
    }

    public String getState() {
        return _state;
    }
    public void setState(String state) {
        _state = state;
    }

    public String getZip() {
        return _zip;
    }
    public void setZip(String zip) {
        _zip = zip;
    }

    public String getType() {
        return _type;
    }
    public void setType(String type) {
        _type = type;
    }

    public String getPhone() {
        return _phone;
    }
    public void setPhone(String phone) {
        _phone = phone;
    }

    public String getWebsite() {
        return _website;
    }
    public void setWebsite(String website) {
        _website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_name);
        dest.writeFloat(_latitude);
        dest.writeFloat(_longitude);
        dest.writeString(_address);
        dest.writeString(_city);
        dest.writeString(_state);
        dest.writeString(_zip);
        dest.writeString(_type);
        dest.writeString(_phone);
        dest.writeString(_website);
    }
}
