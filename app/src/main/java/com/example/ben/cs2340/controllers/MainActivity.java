package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.LocationManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity:";

    static boolean firstCreate = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Starting Main Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (firstCreate) {
            firstCreate = false;
            try {
                // Location data from the CSV is loaded in on startup, change this to Firebase later
                BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("LocationData.csv")));
                LocationManager manager = LocationManager.getInstance();
                manager.parseData(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Logs out the current users and exits to the main screen
     * @param view
     */
    public void onLogoutPressed(View view) {
        //go back to login screen
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void onLocationButtonPressed(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void onAddDonationToFirebasePressed(View view) {
        Intent intent = new Intent(this, AddDonationToFirebase.class);
        startActivity(intent);
    }

    public void onSearchPressed(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
