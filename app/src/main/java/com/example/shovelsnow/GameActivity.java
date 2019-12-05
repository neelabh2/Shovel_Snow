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

import static com.example.shovelsnow.ShopActivity.BACKGROUNDS;

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
        shopButton.setOnClickListener(unused -> shopButtonClicked());
        exitButton.setOnClickListener(unused -> exitButtonClicked());



        // Call updateUI to set initial UI.
        updateUI();

        //switch this to whatever you call the snow ImageView
        ImageView snow = findViewById(R.id.backgroundImage);

        snow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                MediaPlayer shovelSound = MediaPlayer.create(GameActivity.this, R.raw.snowshovel1);
                shovelSound.start();
            }
        });
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
        scoreText.setText(Integer.toString(score));
        //change the background Image
        ImageView background = findViewById(R.id.backgroundImage);
        //make a list of background images

        //one of these images is too large!
        Integer[] listOfImages = {R.drawable.uiucbackground, R.drawable.cs125background, R.drawable.geoffbackground};

        int index = 0;
        for (Background backgroundItem : BACKGROUNDS) {
            if (backgroundItem.getState() == ItemStatusID.EQUIPPED) {
                Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), listOfImages[index]);
                background.setImageBitmap(bImage);
                break;
            }
            index++;
        }
    }

    /**
     * Increases score by the amount specified in ShopActivity when gameButton
     * is clicked.
     */
    private void gameButtonClicked() {
        score += ShopActivity.getPower();
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
}
