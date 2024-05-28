package com.softwarequality.jabberpoint.slide;

import com.softwarequality.jabberpoint.drawer.Drawer;
import com.softwarequality.jabberpoint.drawer.DrawerFactory;
import com.softwarequality.jabberpoint.drawer.TextItem;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlideImplementation implements Slide {
  protected List<SlideComponent> slideComponents;
  private SlideComponent title;

  protected SlideImplementation() {
    this.slideComponents = new ArrayList<>();
  }

  public void setTitle(SlideComponent title) {
    if (title == null) {
      throw new IllegalStateException("Missing title for slide implementation");
    }
    this.title = title;
  }

  protected void appendItem(SlideComponent slideComponent) {
    if (slideComponent == null) {
      throw new IllegalStateException("Cannot append null slide component");
    }
    this.slideComponents.add(slideComponent);
  }

  @Override
  public List<SlideItem> getSlideItems() {
    return slideComponents.stream()
            .filter(c -> c instanceof SlideItem)
            .map(c -> (SlideItem) c)
            .collect(Collectors.toList());
  }

  @Override
  public String getTitle() {
    return title.getText();
  }

  protected void setTitle(String title) {
    if (title == null) {
      throw new IllegalStateException("Cannot set null title in slide implementation");
    }
    this.title = new TextItem(0, title); // Assuming TextItem implements SlideComponent now.
  }

  @Override
  public List<SlideComponent> getSlideComponents() {
    return slideComponents;
  }

  @Override
  public int getSize() {
    return slideComponents.size();
  }

  @Override
  public void draw(Graphics graphics, Rectangle area, ImageObserver observer) {
    if (graphics == null) {
      throw new IllegalStateException("Missing graphics to draw");
    }
    if (area == null) {
      throw new IllegalStateException("Missing area to draw");
    }
    if (observer == null) {
      throw new IllegalStateException("Missing observer to draw");
    }
    float scale = getScale(area);
    int y = area.y;
    DrawerFactory drawerFactory = new DrawerFactory();

    for (SlideComponent component : slideComponents) {
      if (component instanceof SlideItem slideItem) {
        Style style = Style.getStyle(slideItem.getLevel());

        // Create the appropriate drawer for the item
        Drawer drawer = drawerFactory.createDrawer(slideItem);

        // Draw the item using the drawer
        drawer.draw(area.x, y, scale, graphics, style, observer);

        // Adjust y for the next item
        y += slideItem.getBoundingBox(graphics, observer, scale, style).height;
      }
    }
  }

  @Override
  public void add(SlideComponent slideComponent) {
    if (slideComponent == null) {
      throw new IllegalStateException("Cannot add null slide component");
    }
    slideComponents.add(slideComponent);
  }

  @Override
  public void remove(SlideComponent slideComponent) {
    if (slideComponent == null) {
      throw new IllegalStateException("Cannot remove null slide component");
    }
    slideComponents.remove(slideComponent);
  }

  private float getScale(Rectangle area) {
    if (area == null) {
      throw new IllegalStateException("Missing area to get scale");
    }
    return Math.min(
            ((float) area.width) / ((float) SlideConstants.WIDTH),
            ((float) area.height) / ((float) SlideConstants.HEIGHT));
  }
}
