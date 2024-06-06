package com.softwarequality.jabberpoint.slide;

import java.awt.*;

public class Style {
  private static final int STYLE_COUNT = 5;
  private static final int[] INDENTS = {0, 20, 50, 70, 90};
  private static final Color[] COLORS = {
          Color.red, Color.blue, Color.black, Color.black, Color.black
  };
  private static final int[] FONT_SIZES = {48, 40, 36, 30, 24};
  private static final int[] LEADINGS = {20, 10, 10, 10, 10};
  private static final String FONT_NAME = "Helvetica";
  private static Style[] styles;

  private final int indent;
  private final Color color;
  private final Font font;
  private final int fontSize;
  private final int leading;

  public Style(int indent, Color color, int fontSize, int leading) {
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    if (fontSize <= 0) {
      throw new IllegalArgumentException("Font size must be positive");
    }

    this.indent = indent;
    this.color = color;
    this.font = new Font(FONT_NAME, Font.BOLD, fontSize);
    this.fontSize = fontSize;
    this.leading = leading;
  }
  public static void createStyles() {
    styles = new Style[STYLE_COUNT];
    for (int i = 0; i < STYLE_COUNT; i++) {
      styles[i] = new Style(INDENTS[i], COLORS[i], FONT_SIZES[i], LEADINGS[i]);
    }
  }

  public static Style getStyle(int level) {
    int effectiveLevel = level < styles.length ? level : styles.length - 1;
    return styles[effectiveLevel];
  }

  public Font getFont(float scale) {
    return font.deriveFont(fontSize * scale);
  }

  // Getters
  public int getIndent() {
    return indent;
  }

  public Color getColor() {
    return color;
  }

  public int getLeading() {
    return leading;
  }

  @Override
  public String toString() {
    return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
  }
}
