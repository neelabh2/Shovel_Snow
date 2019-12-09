package com.example.shovelsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Displays and allows the user to play the game.
 * Displays buttons for navigating to the shop and exiting the game.
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
     * The ImageView that displays the background.
     */
    private ImageView background;

    /**
     * The ImageView that displays the snow.
     */
    private static ImageView snow;

    /**
     * Called by android when this activity is created.
     * @param savedInstanceState unused.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Setup shopButton, exitButton, scoreText, and background.
        Button shopButton = findViewById(R.id.shopButton);
        Button exitButton = findViewById(R.id.exitButton);
        scoreText = findViewById(R.id.scoreText);
        background = findViewById(R.id.backgroundImage);

        // Set onClickListeners for all buttons.
        shopButton.setOnClickListener(unused -> shopButtonClicked());
        exitButton.setOnClickListener(unused -> exitButtonClicked());

        //Setup the snow ImageView and its listeners.
        snow = findViewById(R.id.snowImage);
        snow.setOnClickListener(unused -> snowClicked());

        // Call updateUI to set initial UI.
        updateUI();
    }

    /**
     * Called by android when this activity is resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    /**
     * @return the user's current score.
     */
    public static int getScore() {
        return score;
    }

    /**
     * Attempts to reduce score by a cost. Used to reduce score when
     * buying items. Score cannot drop below zero.
     * @param cost the cost of the item the user is trying to buy.
     * @return true if cost was not greater than score and score was reduced.
     */
    public static boolean buyItem(final int cost) {
        if (cost > score) {
            return false;
        } else {
            score -= cost;
            return true;
        }
    }

    /**
     * Updates the GameActivity UI.
     */
    private void updateUI() {
        //Update the score.
        scoreText.setText(Integer.toString(score));

        //Change the background.
        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(),
                ShopActivity.getBackroundResource());
        background.setImageBitmap(bImage);
        snow.setImageBitmap(ShopActivity.getSnowBitmap());
        snow.setAlpha(ShopActivity.getSnowAlpha());


        //notify user if snow is depleted
        TextView completedText = findViewById(R.id.completed);
        if (ShopActivity.getSnowAlpha() <= 0) {
            completedText.setVisibility(View.VISIBLE);
        } else {
            completedText.setVisibility(View.GONE);
        }
    }

    /**
     * Increases score and removes snow from the UI
     * when the snow ImageView is clicked.
     */
    private void snowClicked() {
        if (ShopActivity.getSnowAlpha() <= 0) {
            return;
        }
        score += ShopActivity.getPower();
        MediaPlayer shovelSound = MediaPlayer.create(GameActivity.this,
                R.raw.snowshovel1);
        shovelSound.start();
        ShopActivity.shovelSnow();

        //this isn't showing
        //added dependency on the snackbar package - might want to revert later

        updateUI();
    }

    /**
     * Starts ShopActivity when shopButton is clicked.
     */
    private void shopButtonClicked() {
        startActivity(new Intent(this, ShopActivity.class));
    }

    /**
     * Exits the activity when exitButton is clicked.
     */
    private void exitButtonClicked() {
        finish();
    }

    /**
     * Returns the snow ImageView.
     * @return snow ImageView
     */
    public static ImageView getSnow() {
        return snow;
    }
}
