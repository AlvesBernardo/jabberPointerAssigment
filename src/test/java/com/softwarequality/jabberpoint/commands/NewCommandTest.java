package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.mockito.Mockito.*;

public class NewCommandTest {
    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockFrame;
    private NewCommand underTest;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new NewCommand(mockPresentation, mockFrame);
    }

    @Test
    public void execute_shouldCallClear_andRepaint() {
        underTest.execute();
        verify(mockPresentation, times(1)).clear();
        verify(mockFrame, times(1)).repaint();
    }
}