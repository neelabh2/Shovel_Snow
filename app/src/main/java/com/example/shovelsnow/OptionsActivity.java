package com.example.shovelsnow;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Allows the user to modify parts of the game.
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
    }

    /**
     * Exit OptionsActivity when the exitOptions button is clicked.
     */
    private void exitOptionsClicked() {
        finish();
    }
}
