package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BitmapItemDrawer implements Drawer
{
    private final BitmapItem item;

    public BitmapItemDrawer(BitmapItem item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("Missing  item in bitmap item drawer");
        }
        this.item = item;
    }

    public BitmapItem getItem()
    {
        return this.item;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer)
    {
        if (graphics == null)
        {
            throw new RuntimeException("Missing graphic in draw or BitMap Drawer");
        }
        if (style == null)
        {
            throw new RuntimeException("Missing style in draw or BitMap Drawer");
        }
        if (observer == null)
        {
            throw new RuntimeException("Missing observer in draw or BitMap Drawer");
        }
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        graphics.drawImage(item.getImage(), width, height, (int) (item.getImage().getWidth(observer) * scale), (int) (item.getImage().getHeight(observer) * scale), observer);
    }
}
