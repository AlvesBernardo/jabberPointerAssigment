package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class
SlideViewerComponentTest {

    // Create mocks
    Presentation presentation = mock(Presentation.class);
    JFrame frame = mock(JFrame.class);
    Slide slide = mock(Slide.class);

    SlideViewerComponent component;

    @BeforeEach
    void setUp() {
        component = new SlideViewerComponent(presentation, frame);
    }

    @Test
    void constructor_nullPresentation_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new SlideViewerComponent(null, frame));
    }

    @Test
    void constructor_nullFrame_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new SlideViewerComponent(presentation, null));
    }

    @Test
    void getSlide_setSlide_returnsCorrectSlide() {
        component.setSlide(slide);
        assertEquals(slide, component.getSlide());
    }

    @Test
    void setSlide_null_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> component.setSlide(null));
    }

    @Test
    void getFrame_setFrame_returnsCorrectFrame() {
        component.setFrame(frame);
        assertEquals(frame, component.getFrame());
    }

    @Test
    void setFrame_null_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            component.setFrame(null);
        });
    }

    @Test
    void getPresentation_setPresentation_returnsCorrectPresentation() {
        component.setPresentation(presentation);
        assertEquals(presentation, component.getPresentation());
    }

    @Test
    void setPresentation_null_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            component.setPresentation(null);
        });
    }

    // Methods tests
    @Test
    void update_nullPresentation_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            component.update(null, slide);
        });
    }

    @Test
    void update_validParameters_updatesCorrectly() {
        component.update(presentation, slide);
        assertEquals(slide, component.getSlide());
        assertEquals(presentation, component.getPresentation());
    }
}