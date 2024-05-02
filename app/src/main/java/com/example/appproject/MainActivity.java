package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView; // Import TextView

public class MainActivity extends AppCompatActivity {
    Animation topAnimation;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize TextView
        logo = findViewById(R.id.title);

        // Animation
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        logo.startAnimation(topAnimation); // Start animation on logo TextView

        // Delay for 3000 milliseconds (3 seconds) before starting new activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the new activity after the delay
                Intent intent = new Intent(MainActivity.this, HomeActivity2.class);
                startActivity(intent);
                finish(); // Optional: Finish the current activity if needed
            }
        }, 3000);
    }
}