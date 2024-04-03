package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.io.IOException;

public abstract class Accessor {
	public static final String DEMO_NAME = "Demonstration presentation";
	public static final String DEFAULT_EXTENSION = ".xml";

	public static Accessor getDemoAccessor() {
		return new DemoPresentation();
	}

	public Accessor() {
	}

	abstract public void loadFile(PresentationFacade p, String fn) throws IOException;

	abstract public void saveFile(PresentationFacade p, String fn) throws IOException;

}
