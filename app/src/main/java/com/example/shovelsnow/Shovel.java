package com.example.shovelsnow;

public class Shovel extends ShopItem {

    /**
     * The shoveling power of this shovel.
     */
    private int shovelPower;

    /**
     * Creates a new shovel.
     * @param setName the shovel's name.
     * @param setDescription the shovel's description.
     * @param setPrice the shovel's price.
     * @param setState the shovel's state.
     * @param setShovelPower the shovel's power.
     */
    public Shovel(final String setName, final String setDescription,
                  final int setPrice, final int setState,
                  final int setShovelPower) {
        super(setName, setDescription, setPrice, setState);
        shovelPower = setShovelPower;
    }

    /**
     * @return this shovel's power.
     */
    public int getShovelPower() {
        return shovelPower;
    }
}
