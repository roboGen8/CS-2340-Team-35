package com.example.ben.cs2340.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ben.cs2340.R;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle("foo");
    }
}
