package com.example.ben.cs2340.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.Location;
import com.example.ben.cs2340.model.LocationAdapter;
import com.example.ben.cs2340.model.LocationManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    ArrayList<Location> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
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

        RecyclerView rvLocations = (RecyclerView) findViewById(R.id.rvLocations);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("LocationData.csv")));
            locations = LocationManager.parseData(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocationAdapter adapter = new LocationAdapter(locations);
        rvLocations.setAdapter(adapter);
        rvLocations.setLayoutManager(new LinearLayoutManager(this));
    }

}
