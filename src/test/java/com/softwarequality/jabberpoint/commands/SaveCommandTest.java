package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.Constants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SaveCommandTest {
    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockFrame;
    @Mock
    private Accessor mockAccessor;
    @Mock
    private Constants mockConstants;

    private SaveCommand commandUnderTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(mockConstants.getValue(anyString())).thenReturn("Some value");
        commandUnderTest = new SaveCommand(mockPresentation, mockFrame, mockAccessor, mockConstants);
    }

    @Test
    public void execute_shouldSaveFileSuccessfully() throws IOException {
        commandUnderTest.execute();
        verify(mockAccessor, times(1)).saveFile(mockPresentation, "Some value");
    }

    @Test
    public void testExecute_whenExceptionOccurs_shouldShowErrorMessage() {
        SaveCommand spyCommand = spy(commandUnderTest);
        doNothing().when(spyCommand).displayErrorMessage(any(Exception.class));

        try {
            doThrow(IOException.class).when(mockAccessor).saveFile(any(Presentation.class), anyString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        spyCommand.execute();

        verify(spyCommand).displayErrorMessage(any(Exception.class));
    }

    @Test
    public void testGetParent_ShouldReturnCorrectFrames() {
        assertEquals(mockFrame, commandUnderTest.getParent());
    }

    @Test
    public void testGetAccessor_ShouldReturnCorrectAccessor() {
        assertEquals(mockAccessor, commandUnderTest.getAccessor());
    }

    @Test
    public void testGetConstants_ShouldReturnCorrectConstants() {
        assertEquals(mockConstants, commandUnderTest.getConstants());
    }
}