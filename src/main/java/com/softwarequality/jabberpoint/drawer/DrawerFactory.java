package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.SlideItem;

public class DrawerFactory {
    public static Drawer createDrawer(SlideItem item) {
        if (item instanceof BitmapItem) {
            return new BitmapItemDrawer((BitmapItem) item);
        }
        // Add more conditions here for other types of SlideItems
        throw new IllegalArgumentException("No drawer available for this type of item");
    }
}
