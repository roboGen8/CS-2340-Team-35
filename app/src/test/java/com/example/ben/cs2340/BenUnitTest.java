package com.example.ben.cs2340;

import com.example.ben.cs2340.model.Donation;
import com.example.ben.cs2340.model.DonationCategory;
import com.example.ben.cs2340.model.DonationManager;
import com.example.ben.cs2340.model.Location;
import com.example.ben.cs2340.model.LocationManager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BenUnitTest {
    private Donation nullDonation;
    private Donation donation1;
//    private Donation donation2;
    private DonationManager donationManager = DonationManager.getInstance();
    private LocationManager locationManager = LocationManager.getInstance();
    private Location location;
    @Before
    public void setUp(){

        Location location = new Location("", 1, 1, "", "", "", "", "", "", "");
        locationManager.addLocation(location);
        nullDonation = null;
        donation1 = new Donation("1", "", "", 3, DonationCategory.CLOTHING, location);
//        donation2 = new Donation("1", "", "", 3, DonationCategory.CLOTHING, location);
    }

    @Test
    public void add_null() {
        assertEquals(false, donationManager.addDonation(nullDonation));
    }

    @Test
    public void add_first() {
        assertEquals(true, donationManager.addDonation(donation1));
    }

    @Test
    public void add_duplicate(){
        assertEquals(true, donationManager.addDonation(donation1));
    }
}
