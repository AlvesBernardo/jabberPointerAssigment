package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ComponentSlideObserverTest {
    private SlideViewerComponent slideViewerComponent;
    private Presentation presentation;
    private JFrame jFrame;

    @BeforeEach
    public void setUp() {
        presentation = mock(Presentation.class);
        jFrame = mock(JFrame.class);
        slideViewerComponent = new SlideViewerComponent(presentation, jFrame);
    }

    @Test
    public void testConstructor_withNullSlideViewerComponent_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ComponentSlideObserver(null), "Missing slide viewer component in observer");
    }

    @Test
    public void testConstructor_withValidSlideViewerComponent_doesNotThrowException() {
        assertDoesNotThrow(() -> new ComponentSlideObserver(slideViewerComponent));
    }
}