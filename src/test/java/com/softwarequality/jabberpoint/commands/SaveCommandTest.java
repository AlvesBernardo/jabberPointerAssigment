//package com.softwarequality.jabberpoint.commands;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.Accessor;
//import com.softwarequality.jabberpoint.Constants;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//public class SaveCommandTest {
//	@Mock
//	Accessor accessor;
//
//	@Mock
//	Constants constants;
//
//	@Mock
//	Presentation presentation;
//
//	@Mock
//	MessageDialog messageDialog;
//
//	@Mock
//	SaveCommand saveCommand;
//
//	@BeforeEach
//	public void setUp() throws IOException {
//		MockitoAnnotations.openMocks(this);
//		saveCommand = new SaveCommand(presentation, messageDialog, accessor, constants);
//	}
//
//	@Test
//	public void testSaveCommandExecuteWithoutException() throws IOException {
//		// setup
//		String path = "SAVEFILE";
//		when(constants.getValue("SAVEFILE")).thenReturn(path);
//		saveCommand.execute();
//		verify(accessor, times(1)).saveFile(presentation, path);
//	}
//
//	@Test
//	public void testSaveCommandExecuteWithIOException() throws IOException {
//		String path = "SAVEFILE";
//		when(constants.getValue("SAVEFILE")).thenReturn(path);
//		String error = "An IO error occurred.";
//		doThrow(new IOException(error)).when(accessor).saveFile(presentation, path);
//
//		saveCommand.execute();
//
//		verify(accessor, times(1)).saveFile(presentation, path);
//		verify(messageDialog, times(1)).showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
//	}
//}
//}