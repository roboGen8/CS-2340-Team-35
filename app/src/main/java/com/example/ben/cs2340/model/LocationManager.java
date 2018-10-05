package com.example.ben.cs2340.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LocationManager {

    private static LocationManager INSTANCE = new LocationManager();
    public static LocationManager getInstance() {
        return INSTANCE;
    }


    private ArrayList<Location> _locations = new ArrayList<>();


    private boolean addLocation(String name, float latitude, float longitude, String address, String city, String state, String zip, String type, String phone, String website) {
       Location newLocation = new Location(name, latitude, longitude, address, city, state, zip, type, phone, website);
       return _locations.add(newLocation);
    }

    public ArrayList<Location> getLocations() {
        return _locations;
    }

    public void parseData() throws IOException {
        FileReader data = new FileReader("LocationData.csv");
        BufferedReader br = new BufferedReader(data);
        String line;
        while (((line = br.readLine()) != null)) {
            String[] array = line.split(",");
            float latitude = Float.valueOf(array[2]).floatValue();
            float longitude = Float.valueOf(array[3]).floatValue();
            addLocation(array[1], latitude, longitude, array[4], array[5], array[6], array[7], array[8], array[9], array[10]);
        }
    }
}
