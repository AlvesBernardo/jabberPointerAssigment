package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;

import java.io.IOException;

public abstract class Accessor {
  public Accessor() {}

  public static Accessor getDemoAccessor() {
    return new DemoPresentation();
  }

  public abstract void loadFile(Presentation p, String fn) throws IOException;

  public abstract void saveFile(Presentation p, String fn) throws IOException;
}
