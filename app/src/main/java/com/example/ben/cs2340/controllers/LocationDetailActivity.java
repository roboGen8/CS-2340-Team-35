package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ben.cs2340.DemoClass;
import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.Location;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import org.w3c.dom.Text;

public class LocationDetailActivity extends AppCompatActivity {

    public String _name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Intent intent = getIntent();
        Location location = intent.getParcelableExtra("Location");

        _name = location.getName();
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

    public void onViewDonationsPressed(View view) {
        DemoClass.message = _name;
        Intent intent = new Intent(getApplicationContext(), DonationListActivity.class);
        startActivity(intent);
    }

//    button.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
////                openLocationDetail(v);
//            Intent intent = new Intent(v.getContext(), LocationDetailActivity.class);
//            intent.putExtra("Location", location);
//            v.getContext().startActivity(intent);
//        }
//    });
}
