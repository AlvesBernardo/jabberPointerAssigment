package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NextSlideCommandTest {



    @Test
    void testExecute() {
        // Create a mock Presentation instance
        Presentation presentation = new Presentation();

        // Create an instance of NextSlideCommand
        NextSlideCommand nextSlideCommand = new NextSlideCommand(presentation);

        // Test execute method
        assertDoesNotThrow(nextSlideCommand::execute);
    }
}
