package com.example.ben.cs2340.controllers;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.ben.cs2340.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

//    private static final String TAG = "MapsActivity";
//
//    private static final int ERROR_DIALOG_REQUEST = 9001;

//    public boolean isServicesOK() {
////        log.d(TAG, "isServiceOK: checking google services version");
//
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable((MapsActivity.this));
//
//        if (available == ConnectionResult.SUCCESS) {
////            log.d(TAG, "isServiceOK: Google Play Services is working");
//            return true
//        }else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
////            log.d(TAG, "isServiceOK: an error occured but we can fix it");
//            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MapsActivity.this, available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        } else {
//            Toast.makeText(this, "You cant make map requests", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//
//    private void init() {
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng afd = new LatLng(33.75416, -84.37742);
        mMap.addMarker(new MarkerOptions().position(afd).title("AFD Station 4").snippet("(404)555-3456"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(afd));

        LatLng boys = new LatLng(33.73182, -84.43971);
        mMap.addMarker(new MarkerOptions().position(boys).title("BOYS & GILRS CLUB W.W. WOOFOLK").snippet("(404)555-1234"));

        LatLng path = new LatLng(33.70866, -84.41853);
        mMap.addMarker(new MarkerOptions().position(path).title("PATHWAY UPPER ROOM CHRISTIAN MINISTRIES").snippet("(404)555-5432"));

        LatLng pav = new LatLng(33.80129, -84.25537);
        mMap.addMarker(new MarkerOptions().position(pav).title("PAVILION OF HOPE INC").snippet("(404)555-8765"));

        LatLng dd = new LatLng(33.71747, -84.2521);
        mMap.addMarker(new MarkerOptions().position(dd).title("D&D CONVENIENCE STORE").snippet("(404)555-9876"));

        LatLng fulton = new LatLng(33.96921, -84.3688);
        mMap.addMarker(new MarkerOptions().position(fulton).title("KEEP NORTH FULTON BEAUTIFUL").snippet("(707)555-7321"));
    }
}