package com.example.ben.cs2340.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LocationManager {

    private static LocationManager INSTANCE = new LocationManager();
    public static LocationManager getInstance() {
        return INSTANCE;
    }
    private ArrayList<Location> _locations = new ArrayList<>();
    private HashMap<String, Location> _nameMap = new HashMap<>();
    private Location _currentLocation;


//    private ArrayList<Location> _locations = new ArrayList<>();
//
//
//    private boolean addLocation(String name, float latitude, float longitude, String address, String city, String state, String zip, String type, String phone, String website) {
//       Location newLocation = new Location(name, latitude, longitude, address, city, state, zip, type, phone, website);
//       return _locations.add(newLocation);
//    }
//
    public ArrayList<Location> getLocations() {
        return _locations;
    }

    public HashMap<String, Location> getMap() {
        return _nameMap;
    }


    public Location getCurrentLocation() {
        return _currentLocation;
    }

    public void setCurrentLocation(Location _currentLocation) {
        this._currentLocation = _currentLocation;
    }

    public ArrayList<Location> parseData(BufferedReader reader) throws IOException {
//        File f = new File("taco.txt");
//        Log.d("file path", f.getAbsolutePath());
//        ArrayList<Location> list = new ArrayList<>();
//        FileReader data = new FileReader(new File(System.getProperty("user.dir"),"LocationData.csv"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("YourTextFile.txt")));
        String line;

        reader.readLine();
        while (((line = reader.readLine()) != null)) {
            String[] array = line.split(",");
            float latitude = Float.valueOf(array[2]);
            float longitude = Float.valueOf(array[3]);
//            list.add(new Location(array[1], latitude, longitude, array[4], array[5], array[6], array[7], array[8], array[9], array[10]));
            Location newLocation = new Location(array[1], latitude, longitude, array[4], array[5], array[6], array[7], array[8], array[9], array[10]);
            _locations.add(newLocation);
            _nameMap.put(array[1], newLocation);
        }
        return _locations;
    }
}
