package com.example.shovelsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays and allows the user to play the game.
 */
public class GameActivity extends AppCompatActivity {

    /**
     * The user's score. Score is gained by playing the game and is spent in
     * ShopActivity
     */
    private static int score = 0;

    /**
     * The textView that displays the user's score.
     */
    private TextView scoreText;

    /**
     * Called by android when this activity is created.
     * @param savedInstanceState unused.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Setup gameButton, shopButton, exitButton, and scoreText.
        Button gameButton = findViewById(R.id.gameButton);
        Button shopButton = findViewById(R.id.shopButton);
        Button exitButton = findViewById(R.id.exitButton);
        scoreText = findViewById(R.id.scoreText);

        // Set onClickListeners for all buttons.
        gameButton.setOnClickListener(unused -> gameButtonClicked());
        exitButton.setOnClickListener(unused -> exitButtonClicked());

        // Call updateUI to set initial UI.
        updateUI();
    }

    /**
     * Updates the GameActivity UI.
     */
    private void updateUI() {
        scoreText.setText(Integer.toString(score));
    }

    /**
     * Increases score by the amount specified in ShopActivity when gameButton
     * is clicked.
     */
    private void gameButtonClicked() {
        score += 1;
        updateUI();
    }

    /**
     * Exits the activity when exitButton is clicked.
     */
    private void exitButtonClicked() {
        finish();
    }
}
