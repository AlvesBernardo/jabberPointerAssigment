package com.softwarequality.jabberpoint.slideView;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

public class ComponentSlideObserver {

    public ComponentSlideObserver(SlideViewerComponent slideViewerComponent) {
        ValidationUtils.checkNotNull(slideViewerComponent, "Missing slide viewer component in observer");
    }
}
