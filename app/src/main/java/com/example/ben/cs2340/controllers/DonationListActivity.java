package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ben.cs2340.DemoClass;
import com.example.ben.cs2340.R;
import com.example.ben.cs2340.model.Location;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class DonationListActivity extends AppCompatActivity {
    private Firebase mRef;

    private ArrayList<String> mItemNames = new ArrayList<>();

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
        //Need Location string name from LocationDetailActivity
//        Intent intent = getIntent();
//        Location location = intent.getParcelableExtra("Location");
//
//        String location_name = location.getName();


//        String location_name = getIntent().getStringExtra("Location");
//        Intent intent = getIntent();
//        String location_name = intent.getStringExtra("Location");

//        TextView text = (TextView)findViewById(R.id.abc);
//        if (DemoClass.message == null) {
//            text.setText("0");
//        } else {
//            text.setText(DemoClass.message);
//        }

        //------------------

        mRef = new Firebase("https://cs2340-ab302.firebaseio.com/" + DemoClass.message);

        mListView = (ListView)  findViewById(R.id.donationListView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItemNames);

        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String value = dataSnapshot.getValue(String.class);

                mItemNames.add(dataSnapshot.getKey());

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




    }
}
