package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrevSlideCommandTest {

    private Presentation presentation;
    private PrevSlideCommand prevSlideCommand;

    @BeforeEach
    void setUp() {
        presentation = new Presentation() {
            private int slideNumber = 1;

            @Override
            public void prevSlide() {
                if (slideNumber > 0) {
                    slideNumber--;
                }
            }

            @Override
            public int getSlideNumber() {
                return slideNumber;
            }
        };

        prevSlideCommand = new PrevSlideCommand(presentation);
    }

    @Test
    void testExecute() {
        prevSlideCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }
}
