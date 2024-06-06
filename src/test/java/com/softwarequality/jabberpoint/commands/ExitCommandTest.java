package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExitCommandTest {

    @Test
    public void testExecute() {
        Presentation mockPresentation = mock(Presentation.class);
        ExitCommand exitCommand = new ExitCommand(mockPresentation);
        exitCommand.execute();
        verify(mockPresentation, times(1)).exit();
    }
}
