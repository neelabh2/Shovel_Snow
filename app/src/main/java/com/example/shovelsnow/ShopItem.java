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
     * The state of the item (if it is for sale (0), bought (1),
     * or equipped (2).
     */
    private int state;

    /**
     * Creates a new ShopItem.
     * @param setName the item's name.
     * @param setDescription the item's description.
     * @param setPrice the item's price.
     * @param setState the initial state of the item.
     */
    public ShopItem(final String setName, final String setDescription,
                    final int setPrice, final int setState) {
        name = setName;
        description = setDescription;
        price = setPrice;
        state = setState;
    }

    /**
     * @return this item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return this item's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return this item's price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return this item's state.
     */
    public int getState() {
        return state;
    }

    /**
     * Give the item a new state.
     * @param newState the item's new state.
     */
    public void setState(final int newState) {
        state = newState;
    }
}
