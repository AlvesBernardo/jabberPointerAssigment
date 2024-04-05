package com.softwarequality.jabberpoint.slide;

public class SlideBuilder {
  private final SlideImplementation slide;

  public SlideBuilder() {
    this.slide = new SlideImplementation();
  }

  public SlideBuilder withTitle(String title) {
    if (title == null) {
      throw new IllegalStateException("Missing title in slide builder");
    }
    this.slide.setTitle(title);
    return this;
  }

  public SlideBuilder appendItem(SlideItem slideItem) {
    if (slideItem == null) {
      throw new IllegalStateException("Missing slideItem in slide builder");
    }
    this.slide.appendItem(slideItem);
    return this;
  }

  public Slide build() {
    return slide;
  }
}
