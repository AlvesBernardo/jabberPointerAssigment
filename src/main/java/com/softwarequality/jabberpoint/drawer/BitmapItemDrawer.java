package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class BitmapItemDrawer implements Drawer {
    private final BitmapItem item;

    public BitmapItemDrawer(BitmapItem item) {
        this.item = item;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        graphics.drawImage(item.getImage(), width, height, (int) (item.getImage().getWidth(observer) * scale),
                (int) (item.getImage().getHeight(observer) * scale), observer);
    }
}
