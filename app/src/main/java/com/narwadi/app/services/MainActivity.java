package com.narwadi.app.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.narwadi.app.services.model.ImageService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServices();
    }

    // Start Services
    private void startServices() {
        startService(new Intent(getBaseContext(), ImageService.class));
    }

    // Stop Services
    private void stopServices() {
        stopService(new Intent(getBaseContext(), ImageService.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
//        startServices();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopServices();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startServices();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopServices();
    }

}
