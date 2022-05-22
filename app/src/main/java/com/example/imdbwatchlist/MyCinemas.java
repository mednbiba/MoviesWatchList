package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCinemas extends AppCompatActivity {
    Button call,location,call2,location2,call3,location3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cinemas);
        call = findViewById(R.id.call);
        location = findViewById(R.id.call2);
        call2=findViewById(R.id.call31);
        location2=findViewById(R.id.call4);
        call3=findViewById(R.id.call41);
        location3=findViewById(R.id.call3);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("+21671747266");
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maps();


            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("+21636341126");
            }
        });
        location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maps();
            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("+21628531776");
            }
        });
        location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maps();
            }
        });
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void maps (){
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=36.8813828,10.3258791");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
}