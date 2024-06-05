package com.softwarequality.jabberpoint.commands;
import com.softwarequality.jabberpoint.Constants;
import com.softwarequality.jabberpoint.commands.GotoCommand;
import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class GotoCommandTest {

    private Presentation presentation;
    private Frame parent;
    private Constants constants;
    private GotoCommand gotoCommand;

    @BeforeEach
    public void setUp() {
        presentation = mock(Presentation.class);
        parent = mock(Frame.class);
        constants = mock(Constants.class);

        when(constants.getValue(anyString())).thenReturn("Enter slide number:");

        gotoCommand = new GotoCommand(presentation, parent, constants);
    }

    @Test
    public void testExecute_withInvalidNumber() {
        try (var mockedStatic = Mockito.mockStatic(JOptionPane.class)) {
            mockedStatic.when(() -> JOptionPane.showInputDialog(parent, "Enter slide number:"))
                    .thenReturn("abc");
            mockedStatic.when(() -> JOptionPane.showMessageDialog(any(), any(), any(), anyInt()))
                    .thenAnswer(invocation -> null);

            gotoCommand.execute();

            mockedStatic.verify(() -> JOptionPane.showMessageDialog(parent, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE), times(1));
        }
    }

    @Test
    public void testExecute_withOutOfRangeNumber() {
        when(presentation.getSize()).thenReturn(5);

        try (var mockedStatic = Mockito.mockStatic(JOptionPane.class)) {
            mockedStatic.when(() -> JOptionPane.showInputDialog(parent, "Enter slide number:"))
                    .thenReturn("10");
            mockedStatic.when(() -> JOptionPane.showMessageDialog(any(), any(), any(), anyInt()))
                    .thenAnswer(invocation -> null);

            gotoCommand.execute();

            mockedStatic.verify(() -> JOptionPane.showMessageDialog(parent, "Invalid slide number. Please enter a number between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE), times(1));
        }
    }

    @Test
    public void testExecute_withValidNumber() {
        when(presentation.getSize()).thenReturn(5);

        try (var mockedStatic = Mockito.mockStatic(JOptionPane.class)) {
            mockedStatic.when(() -> JOptionPane.showInputDialog(parent, "Enter slide number:"))
                    .thenReturn("3");

            gotoCommand.execute();

            verify(presentation, times(1)).setSlideNumber(2);
        }
    }
}