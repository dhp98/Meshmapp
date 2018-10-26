package com.example.dhyey.codefundoapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

public class MainActivity extends Activity {


    static  int MY_PERMISSIONS_REQUEST_READ_CONTACTS ;

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {


        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // permission was granted, yay! Do the
            // contacts-related task you need to do.
        } else {
            return;
        }
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView  (R.layout.activity_main);
        Sensey.getInstance().init(this);

        final Button messagesButton = (Button) findViewById(R.id.messages);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(getApplicationContext(), WiFiDirectActivity.class);
                startActivity(messageIntent);
            }
        });

        final Button contacts = (Button) findViewById(R.id.contact_invite_button);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(getApplicationContext(), contactsActivity.class);
                startActivity(messageIntent);
            }
        });


        final Button maps = (Button) findViewById(R.id.map);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(messageIntent);
            }
        });

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.SEND_SMS,Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }
    @Override
    protected void onResume() {
        super.onResume();

        Sensey.getInstance().startShakeDetection(shakeListener);
    }

    @Override
    protected void onPause() {
        Sensey.getInstance().stopShakeDetection(shakeListener);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Sensey.getInstance().stop();
        super.onDestroy();
    }

    ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
        @Override
        public void onShakeDetected() {
            Log.d(">>>>>", "Shake Detected");

            // Shake detected, do something
            Intent myIntent = new Intent(MainActivity.this, WiFiDirectActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        }

        @Override
        public void onShakeStopped() {
            // Shake stopped, do something
        }
    };
    }
