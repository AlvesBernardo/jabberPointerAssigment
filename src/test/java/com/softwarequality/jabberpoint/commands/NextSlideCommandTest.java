package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NextSlideCommandTest {
    
    @Test
    void testExecute() {
        Presentation presentation = new Presentation();
        NextSlideCommand nextSlideCommand = new NextSlideCommand(presentation);
        assertDoesNotThrow(nextSlideCommand::execute);
    }
}
