package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slideView.SlideViewerComponent;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.util.ArrayList;

public class Presentation {
    private String showTitle;
    private ArrayList<Slide> showList = new ArrayList<>();
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;

    public Presentation() {
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    public int getSize() {
        return showList.size();
    }

    public String getTitle() {
        return showTitle;
    }

    public void setTitle(String title) {
        ValidationUtils.checkNotNull(title, "Missing title in presentation");
        this.showTitle = title;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSlideNumber() {
        return currentSlideNumber;
    }

    public void setSlideNumber(int number) {
        currentSlideNumber = number;
        if (slideViewComponent != null) {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    public void clear() {
        showList.clear();
        setSlideNumber(-1);
    }

    public void appendSlide(Slide slide) {
        ValidationUtils.checkNotNull(slide, "Cannot append null slide");
        showList.add(slide);
    }

    public Slide getSlide(int number) {
        if (number < 0 || number >= getSize()) {
            return null;
        }
        return showList.get(number);
    }

    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    public void exit() {
        System.exit(0);
    }
}
