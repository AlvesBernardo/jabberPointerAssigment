package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.utils.ValidationUtils;
import com.softwarequality.jabberpoint.utils.CustomObserver;

public class ComponentSlideObserver implements CustomObserver<Slide> {

    public ComponentSlideObserver(SlideViewerComponent slideViewerComponent) {
        ValidationUtils.checkNotNull(slideViewerComponent, "Missing slide viewer component in observer");
        slideViewerComponent.getObservable().addObserver(this);
    }

    @Override
    public void update(Slide slide) {
        System.out.println("Slide updated: " + slide);
    }
}
