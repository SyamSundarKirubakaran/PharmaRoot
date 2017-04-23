package com.bugscript.pharmaroot;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by syamsundark on 01/04/17.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
