package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ben.cs2340.DemoClass;
import com.example.ben.cs2340.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class SearchByCategoryActivity extends AppCompatActivity {

    private Firebase mRef;

    private ArrayList<String> mItemNames = new ArrayList<>();

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_category);

        DemoClass.message = DemoClass.message.replaceAll("[^a-zA-Z]", "");

        mRef = new Firebase("https://cs2340-ab302.firebaseio.com/Category/" + DemoClass.message + "/");

        mListView =  findViewById(R.id.itemByCategory);
//
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItemNames);
//
        mListView.setAdapter(arrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mess = parent.getItemAtPosition(position).toString();
                DemoClass.message = DemoClass.message + "/" + mess;
                Intent intent = new Intent(view.getContext(), SearchDetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });



        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                mItemNames.add(dataSnapshot.getKey());
//                mItemNames.add(DemoClass.message);

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
