package com.softwarequality.jabberpoint.slide;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public interface SlideComponent {
    Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);
    void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
    String getText();   // default method added
}
