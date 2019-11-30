package com.example.shovelsnow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
     * The LinearLayout that holds the shovels for sale.
     */
    private LinearLayout shovelsList;

    /**
     * The LinearLayout that holds the backgrounds for sale.
     */
    private LinearLayout backgroundsList;

    /**
     * The user's current shoveling power.
     */
    private static int power = 1;

    /**
     * An array of the shovels listed in the shop.
     */
    private static final Shovel[] SHOVELS = {
            new Shovel("Your Hand", "x1 shovel power",
                    0, 2, 1),
            new Shovel("Rusty Shovel", "x10 shovel power",
                    15, 0, 10),
            new Shovel("Premium Shovel", "x100 shovel power",
                    150, 0, 100),
            new Shovel("Snowblower", "x1000 shovel power",
                    1500, 0, 1000)
    };

    /**
     * An array of the backgrounds listed in the shop.
     */
    private static final Background[] BACKGROUNDS = {
            new Background("The Quad", "x1 snowfall",
                    0, 2),
            new Background("CS 125", "x10 snowfall",
                    100, 0),
            new Background("Challen", "x100 snowfall",
                    10000, 0)
    };

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

        //Setup shovelsList and backgroundsList
        shovelsList = findViewById(R.id.shovelsList);
        backgroundsList = findViewById(R.id.backgroundsList);

        //Set the initial UI.
        updateUI();
    }

    /**
     * @return the current shovel power.
     */
    public static int getPower() {
        return power;
    }

    /**
     * Updates the ShopActivity UI.
     */
    private void updateUI() {
        // Remove all views from shovelsList and BackgroundsList
        // and set the score.
        shovelsList.removeAllViews();
        backgroundsList.removeAllViews();
        shopScoreText.setText(Integer.toString(GameActivity.getScore()));

        //Create the list of shovels and backgrounds to buy.
        //Iterate through the list of shovels.
        for (Shovel shovel : SHOVELS) {
            //Setup all necessary parts of the item UI.
            View shovelChunk = getLayoutInflater()
                    .inflate(R.layout.chunk_shop_item,
                            shovelsList, false);
            TextView itemName = shovelChunk.findViewById(R.id.itemName);
            TextView itemDescription = shovelChunk
                    .findViewById(R.id.itemDescription);
            Button buyButton = shovelChunk.findViewById(R.id.buyButton);

            //Set the text of the textViews and the button.
            //Set button onClickListeners.
            itemName.setText(shovel.getName());
            itemDescription.setText(shovel.getDescription());
            if (shovel.getState() == ItemStatusID.FORSALE) {
                buyButton.setText(Integer.toString(shovel.getPrice()));
                buyButton.setOnClickListener(unused ->
                        buyButtonClicked(shovel));
            } else if (shovel.getState() == ItemStatusID.BOUGHT) {
                buyButton.setText("Equip");
                buyButton.setOnClickListener(unused ->
                        equipButtonClicked(shovel));
            } else if (shovel.getState() == ItemStatusID.EQUIPPED) {
                buyButton.setText("In Use");
                //Set the current shovel power.
                power = shovel.getShovelPower();
            }

            //Add the shovelChunk to the shovelsList.
            shovelsList.addView(shovelChunk);
        }
        //Iterate through the list of backgrounds.
        for (Background background : BACKGROUNDS) {
            View backgroundChunk = getLayoutInflater()
                    .inflate(R.layout.chunk_shop_item,
                            backgroundsList, false);
            TextView itemName = backgroundChunk.findViewById(R.id.itemName);
            TextView itemDescription = backgroundChunk
                    .findViewById(R.id.itemDescription);
            Button buyButton = backgroundChunk.findViewById(R.id.buyButton);

            //Set the text of the textViews and the button.
            //Set button onClickListeners.
            itemName.setText(background.getName());
            itemDescription.setText(background.getDescription());
            if (background.getState() == ItemStatusID.FORSALE) {
                buyButton.setText(Integer.toString(background.getPrice()));
                buyButton.setOnClickListener(unused ->
                        buyButtonClicked(background));
            } else if (background.getState() == ItemStatusID.BOUGHT) {
                buyButton.setText("Equip");
                buyButton.setOnClickListener(unused ->
                        equipButtonClicked(background));
            } else if (background.getState() == ItemStatusID.EQUIPPED) {
                buyButton.setText("In Use");
            }

            //Add the background chunk to the backgroundsList.
            backgroundsList.addView(backgroundChunk);
        }
    }

    /**
     * Attempts to buy an item and change the item's state
     * when a buy button is clicked.
     * @param shopItem the item to attempt to buy.
     */
    private void buyButtonClicked(final ShopItem shopItem) {
        int cost = shopItem.getPrice();
        if (GameActivity.buyItem(cost)) {
            shopItem.setState(ItemStatusID.BOUGHT);
            updateUI();
        }
    }

    /**
     * Equips an item by changing its state when an equip button is clicked.
     * Unequips all other items by chaning their state.
     * @param shopItem the item to equip.
     */
    private void equipButtonClicked(final ShopItem shopItem) {
        shopItem.setState(ItemStatusID.EQUIPPED);
        if (shopItem instanceof Shovel) {
            for (Shovel shovel : SHOVELS) {
                if (shovel.equals(shopItem)) {
                    continue;
                } else if (shovel.getState() == ItemStatusID.EQUIPPED) {
                    shovel.setState(ItemStatusID.BOUGHT);
                    break;
                }
            }
        } else if (shopItem instanceof Background) {
            for (Background background : BACKGROUNDS) {
                if (background.equals(shopItem)) {
                    continue;
                } else if (background.getState() == ItemStatusID.EQUIPPED) {
                    background.setState(ItemStatusID.BOUGHT);
                    break;
                }
            }
        }
        updateUI();
    }

    /**
     * Exit ShopActivity when the shopExitButton is clicked.
     */
    private void shopExitButtonClicked() {
        finish();
    }
}
