package com.example.shovelsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

/**
 * App launches to this activity.
 * Displays the app title and a button for navigating to GameActivity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The music player for the title screen.
     * **/
    private MediaPlayer titleMusic;

    /**
     * Called by android when this activity is created.
     * @param savedInstanceState unused.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the startButton and optionsButton.
        final Button startButton = findViewById(R.id.startButton);
        final Button optionsButton = findViewById(R.id.optionsButton);

        // Set onClickListener for all buttons.
        startButton.setOnClickListener(unused -> startButtonClicked());
        optionsButton.setOnClickListener(unused -> optionsButtonClicked());

        //not sure why I can't reference R.raw
        titleMusic = MediaPlayer.create(this, R.raw.bensound-thelounge.mp3);
        titleMusic.start();
    }

    /**
     * Starts GameActivity when startButton is clicked.
     */
    private void startButtonClicked() {
        titleMusic.release();
        titleMusic = null;
        startActivity(new Intent(this, GameActivity.class));
    }

    /**
     * Starts optionsActivity when optionsButton is clicked.
     */
    private void optionsButtonClicked() {
        titleMusic.release();
        titleMusic = null;
        startActivity(new Intent(this, OptionsActivity.class));
    }
}
