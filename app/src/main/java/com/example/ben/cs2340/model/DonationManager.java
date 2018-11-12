package com.example.ben.cs2340.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DonationManager {
    private Map<Location, ArrayList<Donation>> _donations;
    private static DonationManager INSTANCE = new DonationManager();
    public static DonationManager getInstance() {
        return INSTANCE;
    }

    public DonationManager() {
        _donations = new HashMap<Location, ArrayList<Donation>>();
        LocationManager managerInstance = LocationManager.getInstance();
        ArrayList<Location> locationList = managerInstance.getLocations();
        for (int i = 0; i < locationList.size(); i++) {
            Location location = locationList.get(i);
            _donations.put(location, new ArrayList<Donation>());
        }
    }

    public Map<Location, ArrayList<Donation>> get_donations() {
        return _donations;
    }

    public boolean addDonation(Donation donation) {
        if (donation == null) {
            return false;
        }
        Location location = donation.get_location();
        if (!_donations.get(location).contains(donation)) {
            _donations.get(location).add(donation);
            return true;
        } else {
            //to implement some sort of inventory number of an item later
            return false;
        }
    }
}
