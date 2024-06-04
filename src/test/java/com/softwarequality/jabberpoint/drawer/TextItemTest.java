package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TextItemTest {

	private TextItem textItem;

	@BeforeEach
	void setUp() {
		textItem = new TextItem(1, "Initial Text");
	}

	@Test
	void testSetText() {
		String newText = "New Text";
		textItem.setText(newText);
		assertEquals(newText, textItem.getText());
	}
//
//	@Test
//	void testGetBoundingBox() {
//		Graphics mockedGraphics = mock(Graphics.class);
//		ImageObserver mockedObserver = mock(ImageObserver.class);
//		Style mockedStyle = mock(Style.class);
//
//		when(mockedStyle.getLeading()).thenReturn(1); // correct type here
//		when(mockedStyle.getIndent()).thenReturn(1);  // correct type here
//
//		Rectangle result = textItem.getBoundingBox(mockedGraphics, mockedObserver, 1.0f, mockedStyle);
//
//		// We should assert something about the result here, check its dimensions for example
//		assertNotNull(result);
//	}
}