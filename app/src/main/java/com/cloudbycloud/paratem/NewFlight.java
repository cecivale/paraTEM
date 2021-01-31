package com.cloudbycloud.paratem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NewFlight extends AppCompatActivity {
    private static final String LOG_TAG =
            NewFlight.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_flight);
    }

    public void launchTEMtool(View view) {
        // Launch TEM tool activity
        Log.d(LOG_TAG, "Button TEM tool clicked");
        Intent intent = new Intent(this, temTool.class);
        startActivity(intent);
    }

    public void launchChecklist(View view) {
        // Launch Checklist activity
        Log.d(LOG_TAG, "Button Checklist clicked");
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
    }
}
