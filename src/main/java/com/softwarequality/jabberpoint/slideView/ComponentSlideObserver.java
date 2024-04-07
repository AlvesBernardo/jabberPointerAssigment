package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;

import java.util.Observable;
import java.util.Observer;

public class ComponentSlideObserver implements Observer {

    private final SlideViewerComponent slideViewerComponent;

    public ComponentSlideObserver(SlideViewerComponent slideViewerComponent) {
        if (slideViewerComponent == null) {
            throw new IllegalStateException("Missing slide viewer component in observer");
        }
        this.slideViewerComponent = slideViewerComponent;
    }

    //TODO::Create a Observer by our own

    @Override
    public void update(Observable observable, Object object) {
        if (object instanceof Slide newSlide) {
            PresentationFacade presentation = slideViewerComponent.getPresentation();
            slideViewerComponent.update(presentation, newSlide);
        }
    }
}
