package com.rkcorner.friendship;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private ImageView imgFriendship;
    private int currentImageIndex = 0;

    // Array holding the drawable references for the images
    private int[] images = {
            R.drawable.friendship_icon,  // First image
            R.drawable.another_image1,   // Second image
            R.drawable.another_image2,
            R.drawable.another_image3// Third image
            // Add more images if needed
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlaySound = findViewById(R.id.btnPlaySound);
        Button btnChangePicture = findViewById(R.id.btnChangePicture);
        Button btnShowToast = findViewById(R.id.btnShowToast);
        imgFriendship = findViewById(R.id.imgFriendship);

        // Initialize MediaPlayer with the friendship theme song
        mediaPlayer = MediaPlayer.create(this, R.raw.friendship_theme);

        // Play/Pause button functionality
        btnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    isPlaying = false;
                    Toast.makeText(MainActivity.this, "Music Paused", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.start();
                    isPlaying = true;
                    Toast.makeText(MainActivity.this, "Music Playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Change Picture button functionality
        btnChangePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the image index, looping back to the start after the last image
                currentImageIndex = (currentImageIndex + 1) % images.length;
                imgFriendship.setImageResource(images[currentImageIndex]);
            }
        });

        // Show Toast button functionality
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Love you my all buddies!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Release the MediaPlayer when activity is destroyed
        }
        super.onDestroy();
    }
}