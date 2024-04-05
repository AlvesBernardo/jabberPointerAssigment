package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slideView.SlideViewerComponent;

public class PresentationFacade implements PresentationInterface {
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

  @Override
  public void initialize() {
    presentation.clear();
  }

  @Override
  public void appendSlide(Slide slide) {
    presentation.appendSlide(slide);
  }

  @Override
  public Slide getCurrentSlide() {
    return presentation.getCurrentSlide();
  }

  @Override
  public void nextSlide() {
    presentation.nextSlide();
  }

  @Override
  public void previousSlide() {
    presentation.prevSlide();
  }

  @Override
  public void exitPresenation() {}

  @Override
  public void clear() {
    presentation.clear();
  }

  @Override
  public void exitPresentation() {
    presentation.exit(1);
  }

  @Override
  public Slide getSlide(int slideNumber) {
    return presentation.getSlide(slideNumber);
  }

  @Override
  public int getSlideNumber() {
    return presentation.getSlideNumber();
  }

  @Override
  public void setSlideNumber(int slideNumber) {
    presentation.setSlideNumber(slideNumber);
  }

  @Override
  public int getSize() {
    return presentation.getSize();
  }

  @Override
  public String getTitle() {
    return presentation.getTitle();
  }

  @Override
  public void setTitle(String title) {
    presentation.setTitle(title);
  }
}
