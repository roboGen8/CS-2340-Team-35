package com.example.ben.cs2340.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ben.cs2340.DemoClass;
import com.example.ben.cs2340.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class SearchDetailActivity extends AppCompatActivity {
    private Firebase mRef;

    private ArrayList<String> mItemNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        if (DemoClass.message.indexOf('/') == -1) {
            mRef = new Firebase("https://cs2340-ab302.firebaseio.com/Item/" + DemoClass.message);
        } else {
            mRef = new Firebase("https://cs2340-ab302.firebaseio.com/Category/" + DemoClass.message);
        }
//        mRef = new Firebase("https://cs2340-ab302.firebaseio.com/Item/" + DemoClass.message);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItemNames);

        final TextView tvItem = findViewById(R.id.item_detail);
        final TextView tvCategory = findViewById(R.id.category_detail);
        final TextView tvLocation = findViewById(R.id.location_detail);
        final TextView tvPrice = findViewById(R.id.price_detail);
        final TextView tvDescription = findViewById(R.id.description_detail);
        final TextView tvTime = findViewById(R.id.timestamp_detail);

//        tvItem.setText(DemoClass.message);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String key = dataSnapshot.getKey();
                String value = dataSnapshot.getValue().toString();
                if (key.equals("Item")) {
                    tvItem.setText(value);
                }
                if (key.equals("Category")) {
                    tvCategory.setText(value);
                }
                if (key.equals("Location")) {
                    tvLocation.setText(value);
                }
                if (key.equals("Price")) {
                    tvPrice.setText(value);
                }
                if (key.equals("Time")) {
                    tvTime.setText(value);
                }
                if (key.equals("Description")) {
                    tvDescription.setText(value);
                }

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
