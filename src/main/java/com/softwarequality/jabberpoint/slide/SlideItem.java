package com.softwarequality.jabberpoint.slide;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class SlideItem implements SlideComponent
{
    List<SlideComponent> slideComponents = new ArrayList<>();
    private int level = 0;

    public SlideItem(int level)
    {
        this.level = level;
    }

    public void add(SlideComponent slideComponent)
    {
        slideComponents.add(slideComponent);
    }

    public void remove(SlideComponent slideComponent)
    {
        slideComponents.remove(slideComponent);
    }

    public int getLevel()
    {
        return level;
    }

    public List<SlideComponent> getSlideComponents()
    {
        return slideComponents;
    }

    @Override
    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    @Override
    public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
}
