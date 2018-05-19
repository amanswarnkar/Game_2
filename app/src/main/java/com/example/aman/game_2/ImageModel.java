package com.example.aman.game_2;

import java.util.HashMap;

/**
 * Created by Aman on 20/03/2018.
 */

public class ImageModel {
    private int imageResource;
    public boolean isSelected = false;

    public ImageModel(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImageResource() {
        return imageResource;
    }

}
