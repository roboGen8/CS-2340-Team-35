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
import com.example.ben.cs2340.model.DonationAdapter;
import com.example.ben.cs2340.model.DonationManager;

public class DonationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
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

        RecyclerView rvDonations = (RecyclerView) findViewById(R.id.rvDonations);
        donations = DonationManager.getInstance().getDonations();
        DonationAdapter adapter = new DonationAdapter(donations);
        rvDonations.setAdapter(adapter);
        rvDonations.setLayoutManager(new LinearLayoutManager(this));
    }

}
