package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.*;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.softwarequality.jabberpoint.presentation.DemoPresentationTest

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DemoPresentationTest {

    private DemoPresentation demoPresentation;
    private PresentationFacade presentationFacade;

    @BeforeEach
    public void setUp() {
        demoPresentation = new DemoPresentation();
        presentationFacade = new PresentationFacade();
    }

    @Test
    public void testLoadFile() {
        demoPresentation.loadFile(presentationFacade, "dummy");

        assertEquals("Demo Presentation", presentationFacade.getTitle());

        // Make sure correct number of slides are loaded
        assertEquals(3, presentationFacade.getSize());

        // Check contents of slide 1 (title, number of items, etc)
        assertEquals("JabberPoint", presentationFacade.getSlide(0).getTitle());
        assertEquals(12, presentationFacade.getSlide(0).getSlideItems().size());

        // Add similar checks for slides 2 and 3
    }

    @Test
    public void testLoadFileNullPresentation() {
        assertThrows(IllegalStateException.class, () -> demoPresentation.loadFile(null, "dummy"));
    }

    @Test
    public void testLoadFileNullFilename() {
        assertThrows(IllegalStateException.class, () -> demoPresentation.loadFile(presentationFacade, null));
    }

    @Test
    public void testSaveFile() {
        assertThrows(IllegalStateException.class, () -> demoPresentation.saveFile(presentationFacade, "dummy-file"));
    }

    @Test
    public void testSaveFileNullPresentation() {
        assertThrows(IllegalStateException.class, () -> demoPresentation.saveFile(null, "dummy-file"));
    }

    @Test
    public void testSaveFileNullFilename() {
        assertThrows(IllegalStateException.class, () -> demoPresentation.saveFile(presentationFacade, null));
    }
}