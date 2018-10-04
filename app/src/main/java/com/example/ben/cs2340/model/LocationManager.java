package com.example.ben.cs2340.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LocationManager {

    private static LocationManager INSTANCE = new LocationManager();
    public static LocationManager getInstance() {
        return INSTANCE;
    }


    private ArrayList<Location> _locations = new ArrayList<>();


    public boolean addLocation(String name, float latitude, float longitude, String address, String city, String state, String zip, String type, String phone, String website) {
       Location newLocation = new Location(name, latitude, longitude, address, city, state, zip, type, phone, website);
       return _locations.add(newLocation);
    }

    public ArrayList<Location> getLocations() {
        return _locations;
    }

    public void parseData() throws IOException {
        FileInputStream data = new FileInputStream("LocationData.csv");
        
    }
}
