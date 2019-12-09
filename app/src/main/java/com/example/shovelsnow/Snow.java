package com.example.shovelsnow;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Class for handling the snow overlay and clicking to shovel snow.
 */
public class Snow {

    /**
     * The background bitmap for this snow overlay.
     */
    private Bitmap background;

    /**
     * The bitmap for this snow overlay.
     */
    private Bitmap bitmap;

    /**
     * The alpha level of this snow.
     */
    private int alpha = 255;

    /**
     * Creates a new bitmap for the snow overlay for a particular background.
     * @param setBackground the background for this snow overlay.
     */
    Snow(final Bitmap setBackground) {
        background = setBackground;

        // Create the bitmap.
        int width = background.getWidth();
        int height = background.getHeight();
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.WHITE);
    }

    /**
     * @return the bitmap for the snow.
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * @return this snow's alpha level.
     */
    public int getAlpha() {
        return alpha;
    }

    /**
     * @param shovelPower the power of the user's shovel.
     * @param snowFall how difficult shoveling is.
     */
    public void shovelSnow(final int shovelPower, final int snowFall) {
        alpha -= shovelPower / snowFall;
        if (alpha < 0) {
            alpha = 0;
        }
    }
}
