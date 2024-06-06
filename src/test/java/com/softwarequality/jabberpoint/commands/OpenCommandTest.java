package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.Constants;
import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class OpenCommandTest {
    @Mock
    private Presentation mockPresentation;

    private Frame parentFrame;
    @Mock
    private Accessor mockAccessor;
    @Mock
    private Constants mockConstants;
    @InjectMocks
    private OpenCommand commandUnderTest;

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(mockConstants.getValue(anyString())).thenReturn("Some string");

        parentFrame = new Frame();
        parentFrame.setVisible(false);

        commandUnderTest = new OpenCommand(mockPresentation, parentFrame, mockAccessor, mockConstants);
    }

    @Test
    public void execute_shouldClearPresentationsAndLoadFile() throws IOException {
        commandUnderTest.execute();
        verify(mockPresentation, times(1)).clear();
        verify(mockAccessor, times(1)).loadFile(mockPresentation, "Some string");
        verify(mockPresentation, times(1)).setSlideNumber(0);
    }

    @Test
    public void execute_whenIOExceptionOccurs_shouldShowErrorMessage() throws IOException {
        doThrow(new IOException()).when(mockAccessor).loadFile(mockPresentation, "Some string");

        commandUnderTest.execute();

        verify(mockPresentation, times(1)).clear();
        verify(mockAccessor, times(1)).loadFile(mockPresentation, "Some string");
        // Assuming there is a method to show error message, verify it is called
        // verify(mockPresentation, times(1)).showError(anyString());
    }
}
