package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.slide.TextItem;
import java.awt.*;
import java.awt.image.ImageObserver;

public class TextItemDrawer implements Drawer {

  private final TextItem textItem;

  public TextItemDrawer(TextItem textItem) {
    if (textItem == null) {
      throw new IllegalArgumentException("Missing text item in text item drawer");
    }
    this.textItem = textItem;
  }

  public TextItem getTextItem() {
    return this.textItem;
  }

  @Override
  public void draw(
      int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
    if (graphics == null) {
      throw new RuntimeException("Missing graphic in draw in Text item drawer");
    }
    if (style == null) {
      throw new RuntimeException("Missing style in draw in text item drawer");
    }
    if (observer == null) {
      throw new RuntimeException("Missing observer in draw in text item drawer");
    }
    textItem.draw(x, y, scale, graphics, style, observer);
  }
}
