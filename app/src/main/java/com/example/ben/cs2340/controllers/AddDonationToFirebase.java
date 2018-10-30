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
    private Firebase mRootRef2;
    private Firebase mRootRef3;
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

                mRootRef = new Firebase("https://cs2340-ab302.firebaseio.com/Location/" + locationStr.replaceAll("[^a-zA-Z]", "") + "/" + itemStr);
                mRootRef2 = new Firebase("https://cs2340-ab302.firebaseio.com/Category/" + categoryStr.replaceAll("[^a-zA-Z]", "") + "/" + itemStr);
                mRootRef3 = new Firebase("https://cs2340-ab302.firebaseio.com/Item/" + itemStr.replaceAll("[^a-zA-Z]", ""));

                //Under Location ----------------
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

                //Under Category ---------------------
                Firebase itemRef2 = mRootRef2.child("Item");
                itemRef2.setValue(itemStr);

                Firebase descriptionRef2 = mRootRef2.child("Description");
                descriptionRef2.setValue(descriptionStr);

                Firebase priceRef2 = mRootRef2.child("Price");
                priceRef2.setValue(priceStr);

                Firebase categoryRef2 = mRootRef2.child("Category");
                categoryRef2.setValue(categoryStr);

                Firebase locationRef2 = mRootRef2.child("Location");
                locationRef2.setValue(locationStr);

                //Under Item -----------------------------
                Firebase itemRef3 = mRootRef3.child("Item");
                itemRef3.setValue(itemStr);

                Firebase descriptionRef3 = mRootRef3.child("Description");
                descriptionRef3.setValue(descriptionStr);

                Firebase priceRef3 = mRootRef3.child("Price");
                priceRef3.setValue(priceStr);

                Firebase categoryRef3 = mRootRef3.child("Category");
                categoryRef3.setValue(categoryStr);

                Firebase locationRef3 = mRootRef3.child("Location");
                locationRef3.setValue(locationStr);


            }
        });


    }
}
