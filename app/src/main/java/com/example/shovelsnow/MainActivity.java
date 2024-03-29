package com.example.shovelsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

/**
 * App launches to this activity.
 * Displays the app title and a button for navigating to GameActivity.
 */

//need to
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

        // Create the game music.
        titleMusic = MediaPlayer.create(this, R.raw.bensoundthelounge);
        titleMusic.start();

        //Setup the bitmaps for the backgrounds and snow.
        for (Background background : ShopActivity.getBackgrounds()) {
            background.setBitmap(getBitmap(background.getResource()));
        }
    }

    /**
     * Starts GameActivity when startButton is clicked.
     */
    private void startButtonClicked() {
        startActivity(new Intent(this, GameActivity.class));
    }

    /**
     * Starts optionsActivity when optionsButton is clicked.
     */
    private void optionsButtonClicked() {
        startActivity(new Intent(this, OptionsActivity.class));
    }

    /**
     * @param resource An image resource.
     * @return The bitmap of that image resource.
     */
    private Bitmap getBitmap(final int resource) {
        return BitmapFactory.decodeResource(this.getResources(), resource);
    }
}
