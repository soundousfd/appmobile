package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.cardview.widget.CardView;

public class HomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        // Load animation
        Animation scaleUpAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        // Apply animation to the desired CardViews
        CardView mapCard = findViewById(R.id.mapCard);
        mapCard.startAnimation(scaleUpAnimation);

        CardView facultyCard = findViewById(R.id.facultyCard);
        facultyCard.startAnimation(scaleUpAnimation);

        CardView faceCard = findViewById(R.id.faceCard);
        faceCard.startAnimation(scaleUpAnimation);

        CardView mailCard = findViewById(R.id.mailCard);
        mailCard.startAnimation(scaleUpAnimation);

        // Set OnClickListener for the mailCard
        mailCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Activity_Contact2 activity
                Intent intent = new Intent(HomeActivity2.this, contactActivity2.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for the faceCard (Facebook)
        faceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Facebook URL in a web browser
                String facebookUrl = "https://www.facebook.com/UMKBiskra";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
                startActivity(intent);
            }
        });

        // Set OnClickListener for the mapCard
        mapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Google Maps with the direction to University Mohamed Kheider
                Uri gmmIntentUri = Uri.parse("google.navigation:q=35.364520, 6.618110"); // Latitude and Longitude of University Mohamed Kheider
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });


        facultyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity2.this, FacultyActivity.class);
                startActivity(intent);
            }
        });
    }
}
