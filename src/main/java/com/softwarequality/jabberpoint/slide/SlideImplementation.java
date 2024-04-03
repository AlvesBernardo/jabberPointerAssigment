package com.softwarequality.jabberpoint.slide;
import java.util.stream.Collectors;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import static com.softwarequality.jabberpoint.slide.SlideConstants.HEIGHT;
import static com.softwarequality.jabberpoint.slide.SlideConstants.WIDTH;

public class SlideImplementation implements Slide {
    private SlideComponent title;
    protected List<SlideComponent> slideComponents;

    protected SlideImplementation() {
        slideComponents = new ArrayList<>();
    }

    protected void setTitle(String title) {
        this.title = new TextItem(0, title);  // Assuming TextItem implements SlideComponent now.
    }

    protected void appendItem(SlideComponent slideComponent) {
        slideComponents.add(slideComponent);
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

    @Override
    public List<SlideComponent> getSlideComponents() {
        return slideComponents;
    }

    @Override
    public int getSize() {
        return slideComponents.size();
    }

    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;
        for (SlideComponent component : slideComponents) {
            if (component instanceof SlideItem) {
                SlideItem slideItem = (SlideItem) component;
                Style style = Style.getStyle(slideItem.getLevel());
                slideItem.draw(area.x, y, scale, g, style, view);
                y += slideItem.getBoundingBox(g, view, scale, style).height;
            }
        }
    }

    @Override
    public void add(SlideComponent slideComponent) {
        slideComponents.add(slideComponent);
    }

    @Override
    public void remove(SlideComponent slideComponent) {
        slideComponents.remove(slideComponent);
    }

    private float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
    }
}
