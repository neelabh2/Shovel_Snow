package com.example.shovelsnow;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Allows the user to modify parts of the game.
 * Displays a button that exits OptionsActivity.
 */
public class OptionsActivity extends AppCompatActivity {

    /**
     * Int representing the volume level.
     */
    private static int volume = 50;

    /**
     * View displaying the volume level.
     */
    private TextView volumeText;

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
        //optionsMusic = MediaPlayer.create(this, R.raw.bensound-thelounge.mp3);
        //optionsMusic.start();

        //creating the audiomanager and button references
        //AudioManager generalManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Button volumeUp = findViewById(R.id.volumeUp);
        volumeUp.setOnClickListener(unused -> volumeUpClicked());
        Button volumeDown = findViewById(R.id.volumeDown);
        volumeDown.setOnClickListener(unused -> volumeDownClicked());
        volumeText = findViewById(R.id.volumeText);
        volumeText.setText(Integer.toString(volume));

        //this might just be adjusting the whole phone's audio, not just the app
        /*maybe create a textview with a number representing the volume?
            it would need to remain constant even after the app is closed
            have it increase/decrease on button press
         */
        //volumeUp.setOnClickListener(unused -> generalManager.adjustVolume(AudioManager.ADJUST_RAISE, 1));
        //volumeDown.setOnClickListener(unused -> generalManager.adjustVolume(AudioManager.ADJUST_LOWER, 1));
    }

    /**
     * Exit OptionsActivity when the exitOptions button is clicked.
     */
    private void exitOptionsClicked() {
        //optionsMusic.release();
        //optionsMusic = null;
        finish();
    }

    /**
     * Increases volume level when volumeUp is clicked.
     */
    private void volumeUpClicked() {
        volume++;
        volumeText.setText(Integer.toString(volume));
    }

    /**
     * Decreases volume level when volumeDown is clicked.
     */
    private void volumeDownClicked() {
        volume--;
        volumeText.setText(Integer.toString(volume));
    }
}
