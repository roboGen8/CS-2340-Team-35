package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.Location;

import org.w3c.dom.Text;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Intent intent = getIntent();
        Location location = intent.getParcelableExtra("Location");

        String _name = location.getName();
        float _latitude = location.getLatitude();
        float _longitude = location.getLongitude();
        String _address = location.getAddress();
        String _city = location.getCity();
        String _state = location.getState();
        String _zip = location.getZip();
        String _type = location.getType();
        String _phone = location.getPhone();
        String _website = location.getWebsite();

        TextView tvLocation = findViewById(R.id.location_detail);
        tvLocation.setText(_name);

        TextView tvCoordinate = findViewById(R.id.coordinate_detail);
        tvCoordinate.setText("" + _latitude + ", " + _longitude);

        TextView tvAddress = findViewById(R.id.address_detail);
        tvAddress.setText("" + _address + ", " + _city + "," + _state + _zip);

        TextView tvType = findViewById(R.id.type_detail);
        tvType.setText("" + _type + "");

        TextView tvPhone = findViewById(R.id.phone_detail);
        tvPhone.setText("" + _phone + "");

        TextView tvWeb = findViewById(R.id.web_detail);
        tvWeb.setText("" + _website + "");

    }
}
