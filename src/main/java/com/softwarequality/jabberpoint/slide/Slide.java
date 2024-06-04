package com.softwarequality.jabberpoint.slide;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;

public interface Slide {
  String getTitle();
  List<SlideItem> getSlideItems();
  List<SlideComponent> getSlideComponents();
  int getSize();
  void draw(Graphics graphics, Rectangle area, ImageObserver view);
  void addComponent(SlideComponent slideComponent);
  void removeComponent(SlideComponent slideComponent);
}
