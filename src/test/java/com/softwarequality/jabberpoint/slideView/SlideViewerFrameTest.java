package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class SlideViewerFrameTest {

    private final Presentation presentation = mock(Presentation.class);

    @Test
    void constructor_nullPresentation_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new SlideViewerFrame("Title", null));
    }

    @Test
    void constructor_validPresentation_createsFrame() {
        String expectedTitle = "Jabberpoint 1.6 - OU";
        SlideViewerFrame frame = new SlideViewerFrame(expectedTitle, presentation);
        assertEquals(expectedTitle, frame.getTitle());
        assertTrue(frame.isVisible());
    }

}
