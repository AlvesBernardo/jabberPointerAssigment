package com.softwarequality.jabberpoint.slide;

import com.softwarequality.jabberpoint.utils.ValidationUtils;

public class SlideBuilder {
  private final SlideImplementation slide;

  public SlideBuilder() {
    this.slide = new SlideImplementation();
  }

  public SlideBuilder withTitle(String title) {
    ValidationUtils.checkNotNull(title, "Missing title in slide builder");
    this.slide.setTitle(title);
    return this;
  }

  public SlideBuilder appendItem(SlideItem slideItem) {
    ValidationUtils.checkNotNull(slideItem, "Missing slideItem in slide builder");
    this.slide.appendItem(slideItem);
    return this;
  }

  public Slide build() {
    return slide;
  }
}
