package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.event.WindowAdapter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class SlideViewerFrameTest {

    private Presentation presentation = mock(Presentation.class);

    @Test
    void constructor_nullPresentation_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new SlideViewerFrame("Title", null));
    }

    @Test
    void constructor_validPresentation_createsFrame() {
        // Arrange
        String expectedTitle = "Jabberpoint 1.6 - OU";

        // Act
        SlideViewerFrame frame = new SlideViewerFrame(expectedTitle, presentation);

        // Assert
        assertEquals(expectedTitle, frame.getTitle());
        assertTrue(frame.isVisible());
    }

//    @Test
//    void setupWindow_correctlyConfiguresFrame() {
//
//        SlideViewerComponent slideViewerComponent = mock(SlideViewerComponent.class);
//        SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);
//        frame.setVisible(false); // To verify that setupWindow sets it to true
//
//        // When
//        frame.setupWindow(slideViewerComponent, presentation);
//
//        // Then
//        assertTrue(frame.isVisible(), "Frame should be visible");
//        assertFalse(frame.getTitle().isEmpty(), "Frame title should be set");
//    }
}
