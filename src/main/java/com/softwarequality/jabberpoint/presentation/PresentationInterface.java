package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;

public interface PresentationInterface {
  void initialize();

  void appendSlide(Slide slide);

  Slide getCurrentSlide();

  void nextSlide();

  void previousSlide();

  void exitPresenation();

  Slide getSlide(int slideNumber);

  void exitPresentation();

  void clear();

  int getSlideNumber();

  void setSlideNumber(int slideNumber);

  int getSize();

  String getTitle();

  void setTitle(String title);
}
