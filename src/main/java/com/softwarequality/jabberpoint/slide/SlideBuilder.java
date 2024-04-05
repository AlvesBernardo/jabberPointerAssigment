package com.softwarequality.jabberpoint.slide;

public class SlideBuilder {
  private final SlideImplementation slide;

  public SlideBuilder() {
    this.slide = new SlideImplementation();
  }

  public SlideBuilder withTitle(String title) {
    this.slide.setTitle(title);
    return this;
  }

  public SlideBuilder appendItem(SlideItem slideItem) {
    this.slide.appendItem(slideItem);
    return this;
  }

  public Slide build() {
    return slide;
  }
}
