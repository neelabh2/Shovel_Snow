package com.example.shovelsnow;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Allows the user to spend score to buy shovels and backgrounds.
 * Bought items can then be equipped.
 * Displays a button for leaving the shop.
 */
public class ShopActivity extends AppCompatActivity {

    /**
     * The textView that displays the user's score.
     */
    private TextView shopScoreText;

    /**
     * Called by android when this activity is created.
     * @param savedInstanceState unused.
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Setup shopExitButton and its onClickListener.
        Button shopExitButton = findViewById(R.id.shopExitButton);
        shopExitButton.setOnClickListener(unused -> shopExitButtonClicked());

        //Setup shopScoreText.
        shopScoreText = findViewById(R.id.shopScoreText);

        //Set the initial UI.
        updateUI();
    }

    /**
     * Updates the ShopActivity UI.
     */
    private void updateUI() {
        shopScoreText.setText(Integer.toString(GameActivity.getScore()));
    }

    /**
     * Exit ShopActivity when the shopExitButton is clicked.
     */
    private void shopExitButtonClicked() {
        finish();
    }
}
