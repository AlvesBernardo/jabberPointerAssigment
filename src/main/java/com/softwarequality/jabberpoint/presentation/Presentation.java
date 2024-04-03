package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slideView.SlideViewerComponent;

import java.util.ArrayList;

public class Presentation
{
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;

    public Presentation()
    {
        slideViewComponent = null;
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        if (slideViewComponent != null)
        {
            PresentationFacade presentationFacade = new PresentationFacade(this);
            slideViewComponent.update(presentationFacade, getCurrentSlide());
        }
    }

    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    public void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    public void appendSlide(Slide slide)
    {
        showList.add(slide);
    }

    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    public void exit(int n)
    {
        System.exit(n);
    }
}
