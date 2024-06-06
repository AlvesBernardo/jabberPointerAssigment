package com.softwarequality.jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Font;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StyleTest {
	private Style style;

	@BeforeEach
	void setUp() {
		Style.createStyles();
		style = Style.getStyle(1);
	}

	@Test
	void whenGetIndentThenReturnCorrectIndent() {
		assertEquals(20, style.getIndent());
	}

	@Test
	void whenGetColorThenReturnCorrectColor() {
		assertEquals(Color.blue, style.getColor());
	}

	@Test
	void whenGetLeadingThenReturnCorrectLeading() {
		assertEquals(10, style.getLeading());
	}

	@Test
	void whenGetFontWithScaleThenReturnCorrectScaledFont() {
		Font scaledFont = style.getFont(2.0f);
		assertEquals(80.0f, scaledFont.getSize2D());
	}
}