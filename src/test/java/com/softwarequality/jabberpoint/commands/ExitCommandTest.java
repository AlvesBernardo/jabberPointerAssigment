package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExitCommandTest {

	@Test
	public void testExecute() {
		// Given
		Presentation mockPresentation = mock(Presentation.class);
		ExitCommand exitCommand = new ExitCommand(mockPresentation);

		// When
		exitCommand.execute();

		// Then
		verify(mockPresentation, times(1)).exit();
	}
}
