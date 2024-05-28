package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextSlideCommandTest {

    private TestablePresentation testablePresentation;
    private NextSlideCommand nextSlideCommand;

    @BeforeEach
    void setUp() {
        Presentation presentation = new Presentation();  // Create a new Presentation
        this.testablePresentation = new TestablePresentation(presentation);
        this.nextSlideCommand = new NextSlideCommand(testablePresentation);
    }

    @Test
    void executeShouldCallNextSlideOnPresentation() {
        // Act
        this.nextSlideCommand.execute();

        // Assert
        assertTrue(this.testablePresentation.nextSlideCalled, "nextSlide method was not called on the presentation");
    }

    class TestablePresentation extends Presentation {

        boolean nextSlideCalled = false;

        @Override
        public void nextSlide() {
            this.nextSlideCalled = true;
            super.nextSlide();
        }

        public TestablePresentation(Presentation presentation) {
            super(presentation);
        }
    }
}
