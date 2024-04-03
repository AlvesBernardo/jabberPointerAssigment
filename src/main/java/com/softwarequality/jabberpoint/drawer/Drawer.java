package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface Drawer {
    void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer);
}
