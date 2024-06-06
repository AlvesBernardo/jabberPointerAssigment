package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.slideView.SlideViewerFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JabberPoinTest {

    Presentation presentation;

    @BeforeEach
    void setUp() {
        Style.createStyles();
        presentation = new Presentation();
        new SlideViewerFrame(JabberPoint.JABVERSION, presentation);
    }

    @Test
    void main_withNoArgs_ShouldNotThrowException() {
        assertDoesNotThrow(() -> JabberPoint.main(new String[]{}));
    }

    @Test
    void main_withArgs_ShouldNotThrowException() {
        assertDoesNotThrow(() -> JabberPoint.main(new String[]{"test.xml"}));
    }
}
