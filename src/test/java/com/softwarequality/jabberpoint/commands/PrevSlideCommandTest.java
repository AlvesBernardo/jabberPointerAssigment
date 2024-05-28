package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrevSlideCommandTest {

    private TestablePresentation testablePresentation;
    private PrevSlideCommand prevSlideCommand;

    @BeforeEach
    void setUp() {
        Presentation presentation = new Presentation();  // Create a new Presentation instance
        this.testablePresentation = new TestablePresentation(presentation);
        this.prevSlideCommand = new PrevSlideCommand(testablePresentation);
    }

    @Test
    void whenExecuteIsCalledThenPreviousSlideShouldBeCalledOnPresentation() {
        // Act
        this.prevSlideCommand.execute();

        // Assert
        assertTrue(this.testablePresentation.isPreviousSlideCalled(), "previousSlide method was not called on the presentation");
    }

    class TestablePresentation extends Presentation {

        private boolean previousSlideCalled = false;

        @Override
        public void previousSlide() {
            this.previousSlideCalled = true;
            super.prevSlide();
        }

        public TestablePresentation(Presentation presentation) {
            super(presentation);
        }

        // Providing an accessor method for the boolean flag
        public boolean isPreviousSlideCalled() {
            return previousSlideCalled;
        }
    }
}
