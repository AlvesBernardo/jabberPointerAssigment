package com.softwarequality.jabberpoint.utils;

import com.softwarequality.jabberpoint.slide.Style;

import java.awt.*;

public class GraphicsUtils
{
    public static Point initializePen(int x, int y, float scale, Style style) {
        int penX = x + (int) (style.getIndent() * scale);
        int penY = y + (int) (style.getLeading() * scale);
        return new Point(penX, penY);
    }
}
