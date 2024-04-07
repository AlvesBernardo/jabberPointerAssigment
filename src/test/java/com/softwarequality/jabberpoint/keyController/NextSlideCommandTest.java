package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.keyController.NextSlideCommand;
import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextSlideCommandTest {

    private TestablePresentationFacade testablePresentation;
    private NextSlideCommand nextSlideCommand;

    @BeforeEach
    void setUp() {
        Presentation presentation = new Presentation();  // Create a new Presentation
        this.testablePresentation = new TestablePresentationFacade(presentation);
        this.nextSlideCommand = new NextSlideCommand(testablePresentation);
    }

    @Test
    void executeShouldCallNextSlideOnPresentation() {
        // Act
        this.nextSlideCommand.execute();

        // Assert
        assertTrue(this.testablePresentation.nextSlideCalled, "nextSlide method was not called on the presentation facade");
    }

    class TestablePresentationFacade extends PresentationFacade {

        boolean nextSlideCalled = false;

        @Override
        public void nextSlide() {
            this.nextSlideCalled = true;
            super.nextSlide();
        }

        public TestablePresentationFacade(Presentation presentation) {
            super(presentation);
        }
    }
}