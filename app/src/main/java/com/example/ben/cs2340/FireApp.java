package com.example.ben.cs2340;

import android.app.Application;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }

}
