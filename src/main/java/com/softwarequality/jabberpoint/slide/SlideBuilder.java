package com.softwarequality.jabberpoint.slide;

public class SlideBuilder {
    private SlideImplementation slide;

    public SlideBuilder() {
        slide = new SlideImplementation();
    }

    public SlideBuilder withTitle(String title){
        slide.setTitle(title);
        return this;
    }

    public SlideBuilder appendItem(SlideItem slideItem){
        slide.appendItem(slideItem);
        return this;
    }

    public Slide build() {
        return slide;
    }
}
