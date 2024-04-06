package com.softwarequality.jabberpoint.drawer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitmapItemDrawerTest {

    private BitmapItemDrawer drawer;
    private BitmapItem bitmapItem;
    private final String imageName = "testImage.png";
    private final int level = 2;


    @Test
    void ConstThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BitmapItemDrawer(null);
        });

    }

}