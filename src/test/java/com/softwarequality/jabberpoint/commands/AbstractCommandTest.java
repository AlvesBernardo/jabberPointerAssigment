package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractCommandTest
{

	@Test
	public void testConstructorWithNonNullPresentation() {
		Presentation presentation = new Presentation();
		AbstractCommand abstractCommand = new TestCommand(presentation);

		assertNotNull(abstractCommand);
		assertEquals(presentation, abstractCommand.presentation);
	}

	@Test
	public void testConstructorWithNullPresentation() {
		Presentation presentation = null;
		assertThrows(IllegalArgumentException.class, () -> new TestCommand(presentation));
	}

	private static class TestCommand extends AbstractCommand {
		TestCommand(Presentation presentation) {
			super(presentation);
		}

		@Override
		public void execute() {
			// Do nothing for testing purposes
		}
	}
}
