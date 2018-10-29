package com.example.ben.cs2340.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ben.cs2340.R;
import com.firebase.client.Firebase;

public class AddDonationToFirebase extends AppCompatActivity {

    private EditText mDonation_Item;
    private Button mAddBtn;

    private Firebase mRootRef;
    private EditText mDonation_Location;

    private EditText mDonation_Price;
    private EditText mDonation_Description;
    private EditText mDonation_Category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation_to_firebase);

        mDonation_Item = (EditText) findViewById(R.id.donation_item);
        mAddBtn = (Button) findViewById(R.id.addBtn);
        mDonation_Location = (EditText) findViewById(R.id.donation_location);
        mDonation_Price = (EditText) findViewById(R.id.donation_price);
        mDonation_Description = (EditText) findViewById(R.id.donation_description);
        mDonation_Category = (EditText) findViewById(R.id.donation_category);





        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationStr = mDonation_Location.getText().toString();
                String itemStr = mDonation_Item.getText().toString();
                String priceStr = mDonation_Price.getText().toString();
                String descriptionStr = mDonation_Description.getText().toString();
                String categoryStr = mDonation_Category.getText().toString();

                mRootRef = new Firebase("https://cs2340-ab302.firebaseio.com/" + locationStr + "/" + itemStr);

                Firebase itemRef = mRootRef.child("Item");
                itemRef.setValue(itemStr);

                Firebase descriptionRef = mRootRef.child("Description");
                descriptionRef.setValue(descriptionStr);

                Firebase priceRef = mRootRef.child("Price");
                priceRef.setValue(priceStr);

                Firebase categoryRef = mRootRef.child("Category");
                categoryRef.setValue(categoryStr);

                Firebase locationRef = mRootRef.child("Location");
                locationRef.setValue(locationStr);

//                mRootRef.push().setValue(value);
            }
        });


    }
}
