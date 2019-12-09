package com.example.shovelsnow;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Allows the user to modify the volume level.
 * Displays a button that exits OptionsActivity.
 */
public class OptionsActivity extends AppCompatActivity {

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

        //Setup Volume buttons.
        Button volumeUp = findViewById(R.id.volumeUp);
        Button volumeDown = findViewById(R.id.volumeDown);
        volumeUp.setOnClickListener(unused -> volumeButtonsClicked(true));
        volumeDown.setOnClickListener(unused -> volumeButtonsClicked(false));

        //Set initial UI.
        updateUI();
    }

    /**
     * Adjusts the volume when volume buttons are clicked.
     * @param increase if the volume is increasing or decreasing.
     */
    private void volumeButtonsClicked(final boolean increase) {
        final double increment = 0.1;
        //creating the audiomanager
        AudioManager generalManager = (AudioManager)
                getSystemService(Context.AUDIO_SERVICE);
        //Find the current and maximum volume.
        int currentVolume = generalManager.getStreamVolume(AudioManager
                .STREAM_MUSIC);
        int maximumVolume = generalManager.getStreamMaxVolume(AudioManager
                .STREAM_MUSIC);
        //Calculate the new volume
        double change = maximumVolume * increment;
        int newVolume;
        if (increase) {
            newVolume = currentVolume + (int) change;
            if (newVolume > maximumVolume) {
                newVolume = maximumVolume;
            }
        } else {
            newVolume = currentVolume - (int) change;
            if (newVolume < 0) {
                newVolume = 0;
            }
        }
        //Set the new volume and update the UI.
        generalManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0);
        updateUI();
    }

    private void updateUI() {
        //creating the audiomanager
        AudioManager generalManager = (AudioManager)
                getSystemService(Context.AUDIO_SERVICE);
        //Find the current volume.
        int currentVolume = generalManager.getStreamVolume(AudioManager
                .STREAM_MUSIC);
        //Update the volumeText.
        TextView volumeText = findViewById(R.id.volumeText);
        volumeText.setText(Integer.toString(currentVolume));
    }

    /**
     * Exit OptionsActivity when the exitOptions button is clicked.
     */
    private void exitOptionsClicked() {
        finish();
    }
}
