package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;

import java.util.Observable;
import java.util.Observer;

public class ComponentSlideObserver {

    private final SlideViewerComponent slideViewerComponent;

    public ComponentSlideObserver(SlideViewerComponent slideViewerComponent) {
        if (slideViewerComponent == null) {
            throw new IllegalStateException("Missing slide viewer component in observer");
        }
        this.slideViewerComponent = slideViewerComponent;
    }

    public void accept(Slide newSlide) {
        PresentationFacade presentation = slideViewerComponent.getPresentation();
        slideViewerComponent.update(presentation, newSlide);
    }
}
