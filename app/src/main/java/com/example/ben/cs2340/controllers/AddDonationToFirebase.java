package com.example.ben.cs2340.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ben.cs2340.R;
import com.firebase.client.Firebase;

public class AddDonationToFirebase extends AppCompatActivity {

    private EditText mValueField;
    private Button mAddBtn;

    private Firebase mRootRef;
    private EditText mKeyValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation_to_firebase);

        mRootRef = new Firebase("https://cs2340-ab302.firebaseio.com/Users");

        mValueField = (EditText) findViewById(R.id.valueField);
        mAddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);



        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

                Firebase childRef = mRootRef.child(key);

                childRef.setValue(value);
//                mRootRef.push().setValue(value);
            }
        });


    }
}
