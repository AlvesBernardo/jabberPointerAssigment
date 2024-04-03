package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;

public interface PresentationInterface {
    void initialize();
    void setTitle(String title);
    void appendSlide(Slide slide);
    Slide getCurrentSlide();
    void nextSlide();
    void previousSlide();
    void exitPresenation();
    Slide getSlide(int slideNumber);
    void exitPresentation();
    void clear();
    void setSlideNumber(int slideNumber);
    int getSlideNumber();

    int getSize();

    String getTitle();
}
