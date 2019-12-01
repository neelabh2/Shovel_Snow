package com.example.shovelsnow;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Allows the user to modify parts of the game.
 * Displays a button that exits OptionsActivity.
 */
public class OptionsActivity extends AppCompatActivity {

    /**
     * Music that plays in the options activity.
     */
    private MediaPlayer optionsMusic;

    /**
     * Called by android when this activity is created.
     * @param savedInstanceState unused.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        // Setup the exitOptionsButton and its onClickListener
        Button exitOptionsButton = findViewById(R.id.exitOptionsButton);
        exitOptionsButton.setOnClickListener(unused -> exitOptionsClicked());

        //not sure why I can't reference R.raw
        optionsMusic = MediaPlayer.create(this, R.raw.bensound-thelounge.mp3);
        optionsMusic.start();

        //creating the audiomanager and button references
        AudioManager generalManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Button volumeUp = findViewById(R.id.volumeUp);
        Button volumeDown = findViewById(R.id.volumeDown);

        //this might just be adjusting the whole phone's audio, not just the app
        /*maybe create a textview with a number representing the volume?
            it would need to remain constant even after the app is closed
            have it increase/decrease on button press
         */
        volumeUp.setOnClickListener(unused -> generalManager.adjustVolume(AudioManager.ADJUST_RAISE, 1));
        volumeDown.setOnClickListener(unused -> generalManager.adjustVolume(AudioManager.ADJUST_LOWER, 1));

        //not sure if we'll be able to change the background image so no work on that here just yet, besides adding a spinner for it.

        //do we want to add different kinds of weather? That's an option, but I guess we'll have to know more about bitmaps first

        //Need to make it so you can select different shovels.

    }

    /**
     * Exit OptionsActivity when the exitOptions button is clicked.
     */
    private void exitOptionsClicked() {
        optionsMusic.release();
        optionsMusic = null;
        finish();
    }
}
