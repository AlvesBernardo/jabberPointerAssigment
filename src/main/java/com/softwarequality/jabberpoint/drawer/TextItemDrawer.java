package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.utils.GraphicsUtils;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.util.List;

public class TextItemDrawer implements Drawer {
  private final TextItem textItem;

  public TextItemDrawer(TextItem textItem) {
    ValidationUtils.checkNotNull(textItem, "TextItem cannot be null");
    this.textItem = textItem;
  }

  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
    ValidationUtils.checkNotNull(graphics, "Graphics cannot be null");
    ValidationUtils.checkNotNull(style, "Style cannot be null");
    ValidationUtils.checkNotNull(observer, "Observer cannot be null");

    List<TextLayout> layouts = textItem.getLayouts(graphics, style, scale);
    drawLayouts(x, y, scale, (Graphics2D) graphics, style, layouts);
  }

  static void drawLayouts(int x, int y, float scale, Graphics2D graphics, Style style, List<TextLayout> layouts) {
    Point pen = GraphicsUtils.initializePen(x, y, scale, style);
    graphics.setColor(style.getColor());

    for (TextLayout layout : layouts) {
      pen.y += (int) layout.getAscent();
      layout.draw(graphics, pen.x, pen.y);
      pen.y += (int) layout.getDescent();
    }
  }
}
