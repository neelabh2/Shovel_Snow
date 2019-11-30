package com.example.shovelsnow;

/**
 * Stores data about an item in the shop.
 */
public abstract class ShopItem {

    /**
     * The name of the item.
     */
    private String name;

    /**
     * The description of the item.
     */
    private String description;

    /**
     * The score that must by paid the buy the item.
     */
    private int price;

    /**
     * The state of the item (if it is not bought, bought, or equipped).
     */
    private int state;


}
