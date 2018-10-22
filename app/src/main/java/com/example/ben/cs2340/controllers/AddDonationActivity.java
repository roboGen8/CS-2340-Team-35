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
import com.example.ben.cs2340.model.DonationCategory;

import java.util.Calendar;
import java.util.Date;

public class AddDonationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private EditText briefDescriptionField;
    private EditText fullDescriptionField;
    private EditText priceField;
    private Spinner categorySpinner;
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

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, DonationCategory.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    public void onAddDonationPressed(View view) {
        Date currentTime = Calendar.getInstance().getTime();
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
