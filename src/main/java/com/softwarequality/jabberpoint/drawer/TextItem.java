package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.SlideConstants;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

public class TextItem extends SlideItem {
  private String text;

  public TextItem(int level, String string) {
    super(level);
    setText(string);
  }

  public String getText() {
    return text == null ? "" : text;
  }

  public void setText(String newText) {
    ValidationUtils.checkNotNull(newText, "Text cannot be null");
    this.text = newText;
  }

  public AttributedString getAttributedString(Style style, float scale) {
    ValidationUtils.checkNotNull(style, "Style cannot be null");
    AttributedString attrStr = new AttributedString(getText());
    attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
    return attrStr;
  }

  @Override
  public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style) {
    validateParameters(graphics, observer, style);
    List<TextLayout> layouts = getLayouts(graphics, style, scale);
    return calculateBoundingBox(layouts, style, scale);
  }

  private Rectangle calculateBoundingBox(List<TextLayout> layouts, Style style, float scale) {
    int xsize = 0, ysize = (int) (style.getLeading() * scale);
    for (TextLayout layout : layouts) {
      Rectangle2D bounds = layout.getBounds();
      xsize = Math.max(xsize, (int) bounds.getWidth());
      ysize += (int) bounds.getHeight();
      ysize += (int) (layout.getLeading() + layout.getDescent());
    }
    return new Rectangle((int) (style.getIndent() * scale), 0, xsize, ysize);
  }

  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
    validateParameters(graphics, observer, style);
    List<TextLayout> layouts = getLayouts(graphics, style, scale);
    TextItemDrawer.drawLayouts(x, y, scale, (Graphics2D) graphics, style, layouts);
  }

  public List<TextLayout> getLayouts(Graphics graphics, Style style, float scale) {
    ValidationUtils.checkNotNull(graphics, "Graphics cannot be null");

    List<TextLayout> layouts = new ArrayList<>();
    AttributedString attrStr = getAttributedString(style, scale);
    Graphics2D g2d = (Graphics2D) graphics;
    FontRenderContext frc = g2d.getFontRenderContext();
    LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    float wrappingWidth = (SlideConstants.WIDTH - style.getIndent()) * scale;
    while (measurer.getPosition() < getText().length()) {
      TextLayout layout = measurer.nextLayout(wrappingWidth);
      layouts.add(layout);
    }
    return layouts;
  }

  @Override
  public String toString() {
    return "TextItem[" + getLevel() + "," + getText() + "]";
  }

  private void validateParameters(Graphics graphics, ImageObserver observer, Style style) {
    ValidationUtils.checkNotNull(graphics, "Graphics cannot be null");
    ValidationUtils.checkNotNull(observer, "Observer cannot be null");
    ValidationUtils.checkNotNull(style, "Style cannot be null");
  }
}
