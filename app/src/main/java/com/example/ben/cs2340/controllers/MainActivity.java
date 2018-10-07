package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.controllers.LoginActivity;
import com.example.ben.cs2340.model.Account;
import com.example.ben.cs2340.model.LoginService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Account a = LoginService.getInstance().getCurrentAccount();
        setTitle("Welcome back " + a.getName());
    }

    public void onLogoutPressed(View view) {
        LoginService model = LoginService.getInstance();
        //ask model to log out the current user
        model.logout();
        //go back to login screen
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onLocationButtonPressed(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
}
