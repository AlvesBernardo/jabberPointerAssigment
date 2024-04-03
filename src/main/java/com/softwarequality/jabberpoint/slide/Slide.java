package com.softwarequality.jabberpoint.slide;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.List;

public interface Slide {
	String getTitle();
	List<SlideItem> getSlideItems();
	List<SlideComponent> getSlideComponents();
	int getSize();
	void draw(Graphics g, Rectangle area, ImageObserver view);
	void add(SlideComponent slideComponent);
	void remove(SlideComponent slideComponent);
}
