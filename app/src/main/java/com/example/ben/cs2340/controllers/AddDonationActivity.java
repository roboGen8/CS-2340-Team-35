package com.example.ben.cs2340.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.Donation;
import com.example.ben.cs2340.model.DonationCategory;
import com.example.ben.cs2340.model.DonationManager;
import com.example.ben.cs2340.model.Location;
import com.example.ben.cs2340.model.LocationManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AddDonationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private EditText briefDescriptionField;
    private EditText fullDescriptionField;
    private EditText priceField;
    private Spinner categorySpinner;
    private Spinner locationSpinner;
    private DonationCategory category = DonationCategory.CLOTHING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        briefDescriptionField = (EditText) findViewById(R.id.brief_description_input);
        fullDescriptionField = (EditText) findViewById(R.id.full_description_input);
        priceField = (EditText) findViewById(R.id.price_input);
        categorySpinner = (Spinner) findViewById(R.id.category_spinner);
        locationSpinner = (Spinner) findViewById(R.id.location_spinner);

        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, DonationCategory.values());
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter1);

        LocationManager manager = LocationManager.getInstance();
        ArrayList<Location> locationArray = manager.getLocations();
        ArrayList<String> stringArray = new ArrayList<>();
        int i;
        for (i = 0; i < locationArray.size(); i++){
            stringArray.add(locationArray.get(i).toString());
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, stringArray);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter2);
    }

    public void onAddDonationPressed(View view) {
        String currentTime = Calendar.getInstance().getTime().toString();
        String briefDescription = briefDescriptionField.getText().toString();
        String fullDescription = fullDescriptionField.getText().toString();
        Double price = Double.valueOf(priceField.getText().toString());
        DonationCategory category = (DonationCategory) categorySpinner.getSelectedItem();
        LocationManager manager = LocationManager.getInstance();
        HashMap<String, Location> map = manager.getMap();
        String selectedLocation = (String) locationSpinner.getSelectedItem();
        Location location = map.get(selectedLocation);
        Donation donation = new Donation(currentTime, briefDescription, fullDescription, price, category, location);
        DonationManager.getInstance().addDonation(donation);
        finish();
    }

    public void onCancelPressed(View view) {
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        category = (DonationCategory) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        category = DonationCategory.CLOTHING;
    }

}
