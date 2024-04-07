package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slideView.SlideViewerComponent;

public class PresentationFacade {
  private final Presentation presentation;

  public PresentationFacade(Presentation presentation) {
    this.presentation = presentation;
  }

  public void exit() {
    System.exit(0);
  }

  public void setShowView(SlideViewerComponent slideViewerComponent) {
    presentation.setShowView(slideViewerComponent);
  }

  public void initialize() {
    presentation.clear();
  }

  public void appendSlide(Slide slide) {
    presentation.appendSlide(slide);
  }

  public Slide getCurrentSlide() {
    return presentation.getCurrentSlide();
  }

  public void nextSlide() {
    presentation.nextSlide();
  }

  public void previousSlide() {
    presentation.prevSlide();
  }

  public void clear() {
    presentation.clear();
  }

  public void exitPresentation() {
    presentation.exit(1);
  }

  public Slide getSlide(int slideNumber) {
    return presentation.getSlide(slideNumber);
  }

  public int getSlideNumber() {
    return presentation.getSlideNumber();
  }

  public void setSlideNumber(int slideNumber) {
    presentation.setSlideNumber(slideNumber);
  }

  public int getSize() {
    return presentation.getSize();
  }

  public String getTitle() {
    return presentation.getTitle();
  }

  public void setTitle(String title) {
    presentation.setTitle(title);
  }
}
