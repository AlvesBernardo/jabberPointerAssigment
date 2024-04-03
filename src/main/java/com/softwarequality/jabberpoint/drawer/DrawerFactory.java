package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.slide.TextItem;

public class DrawerFactory
{
    public static Drawer createDrawer(SlideItem item)
    {
        if (item instanceof TextItem)
        {
            return new TextItemDrawer((TextItem) item);
        } else if (item instanceof BitmapItem)
        {
            return new BitmapItemDrawer((BitmapItem) item);
        } else
        {
            throw new IllegalArgumentException("No drawer for SlideItem: " + item);
        }
    }
}
