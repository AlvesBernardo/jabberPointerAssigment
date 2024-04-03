package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;
import java.util.Observable;
import java.util.Observer;

public class ComponentSlideObserver implements Observer {

    private final SlideViewerComponent slideViewerComponent;

    public ComponentSlideObserver(SlideViewerComponent slideViewerComponent) {
        this.slideViewerComponent = slideViewerComponent;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Slide) {
            Slide newSlide = (Slide) arg;
            PresentationFacade presentation = slideViewerComponent.getPresentation();
            slideViewerComponent.update(presentation, newSlide);
        }
    }
}
