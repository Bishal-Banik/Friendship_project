package com.rkcorner.friendship;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean isPlaying = false; // Variable to track if the music is playing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Uses the updated LinearLayout XML file

        // Initialize UI components
        TextView tvFriendshipMessage = findViewById(R.id.tvFriendshipMessage);
        ImageView imgFriendship = findViewById(R.id.imgFriendship);
        Button btnPlayPauseSound = findViewById(R.id.btnPlaySound);
        Button btnShowToast = findViewById(R.id.btnShowToast);

        // Set the friendship message
        tvFriendshipMessage.setText("Happy Friendship Day!");

        // Set the MediaPlayer to play the friendship theme
        mediaPlayer = MediaPlayer.create(this, R.raw.friendship_theme); // Ensure the MP3 file is placed in res/raw

        // Toggle play/pause on button click with Toast messages
        btnPlayPauseSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    // If music is currently playing, pause it
                    mediaPlayer.pause();
                    btnPlayPauseSound.setText("Play Friendship Theme"); // Change button text to "Play"
                    isPlaying = false;  // Update status

                    // Show a Toast indicating that music is paused
                    Toast.makeText(MainActivity.this, "Music Paused", Toast.LENGTH_SHORT).show();
                } else {
                    // If music is paused, start playing
                    mediaPlayer.start();
                    btnPlayPauseSound.setText("Pause Friendship Theme"); // Change button text to "Pause"
                    isPlaying = true;  // Update status

                    // Show a Toast indicating that music is playing
                    Toast.makeText(MainActivity.this, "Music Playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Show a general Toast message on button click
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Love you my all friends", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}