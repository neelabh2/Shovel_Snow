package com.example.shovelsnow;

import android.graphics.Bitmap;

public class Background extends ShopItem {

    /**
     * The resource file containing the image of the background.
     */
    private int resource;

    /**
     * How much effort it takes to clear this snow.
     */
    private int snowFall;

    /**
     * The snow overlay for this background.
     */
    private Snow snow;

    /**
     * Creates a new background.
     * @param setName the background's name.
     * @param setDescription the background's description.
     * @param setPrice the background's price.
     * @param setState the background's state.
     * @param setResource the resource file containing the image of
     *                    the background.
     * @param setSnow how difficult it will be to clear the snow.
     */
    Background(final String setName, final String setDescription,
                      final int setPrice, final int setState,
                      final int setResource, final int setSnow) {
        super(setName, setDescription, setPrice, setState);
        resource = setResource;
        snowFall = setSnow;
    }

    /**
     * Sets the bitmap of the backround and creates the snow.
     * @param setBitmap the bitmap of the backround.
     */
    public void setBitmap(final Bitmap setBitmap) {
        snow = new Snow(setBitmap);
    }

    /**
     * @return the resource file containing the image of the background.
     */
    public int getResource() {
        return resource;
    }

    /**
     * @return the shoveling difficulty of this backround.
     */
    public int getSnowFall() {
        return snowFall;
    }

    /**
     * @return the snow of this bitmap.
     */
    public Snow getSnow() {
        return snow;
    }
}
