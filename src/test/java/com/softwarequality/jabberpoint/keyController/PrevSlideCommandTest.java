package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.keyController.PrevSlideCommand;
import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrevSlideCommandTest {

    private TestablePresentationFacade testablePresentationFacade;
    private PrevSlideCommand prevSlideCommand;

    @BeforeEach
    void setUp() {
        Presentation presentation = new Presentation();  // Create a new Presentation instance
        this.testablePresentationFacade = new TestablePresentationFacade(presentation);
        this.prevSlideCommand = new PrevSlideCommand(testablePresentationFacade);
    }

    @Test
    void whenExecuteIsCalledThenPreviousSlideShouldBeCalledOnPresentation() {
        // Act
        this.prevSlideCommand.execute();

        // Assert
        assertTrue(this.testablePresentationFacade.isPreviousSlideCalled(), "previousSlide method was not called on the presentation facade");
    }

    class TestablePresentationFacade extends PresentationFacade {

        private boolean previousSlideCalled = false;

        @Override
        public void previousSlide() {
            this.previousSlideCalled = true;
            super.previousSlide();
        }

        public TestablePresentationFacade(Presentation presentation) {
            super(presentation);
        }

        // Providing an accessor method for the boolean flag
        public boolean isPreviousSlideCalled() {
            return previousSlideCalled;
        }
    }
}