package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.TextItem;
import com.softwarequality.jabberpoint.slide.Style;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class TextItemDrawer implements Drawer {

    private final TextItem textItem;

    public TextItemDrawer(TextItem textItem) {
        this.textItem = textItem;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
        textItem.draw(x, y, scale, g, style, observer);
    }
}
