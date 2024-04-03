package com.softwarequality.jabberpoint.slide;

import com.softwarequality.jabberpoint.drawer.Drawer;
import com.softwarequality.jabberpoint.drawer.DrawerFactory;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.softwarequality.jabberpoint.slide.SlideConstants.HEIGHT;
import static com.softwarequality.jabberpoint.slide.SlideConstants.WIDTH;

public class SlideImplementation implements Slide
{
    protected List<SlideComponent> slideComponents;
    private SlideComponent title;

    protected SlideImplementation()
    {
        this.slideComponents = new ArrayList<>();
    }

    protected void appendItem(SlideComponent slideComponent)
    {
        this.slideComponents.add(slideComponent);
    }

    @Override
    public List<SlideItem> getSlideItems()
    {
        return slideComponents.stream()
                .filter(c -> c instanceof SlideItem)
                .map(c -> (SlideItem) c)
                .collect(Collectors.toList());
    }

    @Override
    public String getTitle()
    {
        return title.getText();
    }

    protected void setTitle(String title)
    {
        this.title = new TextItem(0, title);  // Assuming TextItem implements SlideComponent now.
    }

    @Override
    public List<SlideComponent> getSlideComponents()
    {
        return slideComponents;
    }

    @Override
    public int getSize()
    {
        return slideComponents.size();
    }

    @Override
    public void draw(Graphics graphics, Rectangle area, ImageObserver observer)
    {
        float scale = getScale(area);
        int y = area.y;

        for (SlideComponent component : slideComponents)
        {
            if (component instanceof SlideItem slideItem)
            {
                Style style = Style.getStyle(slideItem.getLevel());

                // Create the appropriate drawer for the item
                Drawer drawer = DrawerFactory.createDrawer(slideItem);

                // Draw the item using the drawer
                drawer.draw(area.x, y, scale, graphics, style, observer);

                // Adjust y for the next item
                y += slideItem.getBoundingBox(graphics, observer, scale, style).height;
            }
        }
    }

    @Override
    public void add(SlideComponent slideComponent)
    {
        slideComponents.add(slideComponent);
    }

    @Override
    public void remove(SlideComponent slideComponent)
    {
        slideComponents.remove(slideComponent);
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
