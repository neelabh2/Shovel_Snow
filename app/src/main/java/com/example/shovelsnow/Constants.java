package com.example.shovelsnow;

// This file holds numeric constants

/**
 * Holds constant values for the possible item states.
 */
class ItemStatusID {

    protected ItemStatusID() {
        throw new UnsupportedOperationException();
    }

    /**
     * ID for an item that is available for sale.
     */
    static final int FORSALE = 0;

    /**
     * ID for an item that has been bought.
     */
    static final int BOUGHT = 1;

    /**
     * ID for an item that is equipped.
     */
    static final int EQUIPPED = 2;
}
