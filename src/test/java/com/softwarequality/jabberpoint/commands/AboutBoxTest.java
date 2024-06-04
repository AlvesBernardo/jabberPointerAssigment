package com.softwarequality.jabberpoint.commands;

import org.junit.jupiter.api.Test;
import javax.swing.JFrame;

import static org.junit.jupiter.api.Assertions.*;

public class AboutBoxTest {

	@Test
	public void testShow() {
		// Given
		JFrame parentFrame = new JFrame();

		// When
		AboutBox.show(parentFrame);

		// Then
		// No exception should be thrown
		assertTrue(true);
	}
}
