package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.utils.GraphicsUtils;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BitmapItemDrawer implements Drawer {
  private final BitmapItem bitmapItem;

  public BitmapItemDrawer(BitmapItem bitmapItem) {
    ValidationUtils.checkNotNull(bitmapItem, "BitmapItem cannot be null");
    this.bitmapItem = bitmapItem;
  }

  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
    ValidationUtils.checkNotNull(graphics, "Graphics cannot be null");
    ValidationUtils.checkNotNull(style, "Style cannot be null");
    ValidationUtils.checkNotNull(observer, "Observer cannot be null");

    Point pen = GraphicsUtils.initializePen(x, y, scale, style);

    graphics.drawImage(
            bitmapItem.getBufferedImage(),
            pen.x,
            pen.y,
            (int) (bitmapItem.getBufferedImage().getWidth(observer) * scale),
            (int) (bitmapItem.getBufferedImage().getHeight(observer) * scale),
            observer
    );
  }
}
