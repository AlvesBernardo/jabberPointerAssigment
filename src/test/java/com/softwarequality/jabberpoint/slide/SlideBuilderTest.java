package com.softwarequality.jabberpoint.slide;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.softwarequality.jabberpoint.slide.SlideItem;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

class SlideBuilderTest {
    private SlideBuilder slideBuilder;

    @BeforeEach
    void setUp() {
        this.slideBuilder = new SlideBuilder();
    }

	@Test
	void givenNullTitleWhenWithTitleThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> this.slideBuilder.withTitle(null));
	}


    @Test
    void givenTitleWhenWithTitleThenSlideTitleIsSet() {
        String testTitle = "Test Title";
        this.slideBuilder.withTitle(testTitle);
        Slide slide = this.slideBuilder.build();
        assertEquals(testTitle, slide.getTitle());
    }

	@Test
	void givenNullSlideItemWhenAppendItemThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> this.slideBuilder.appendItem(null));
	}

    @Test
    void givenSlideItemWhenAppendItemThenSlideItemIsAdded() {
        SlideItem testSlideItem = new SlideItem(1) {
            @Override
            public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
                return new Rectangle();
            }

            @Override
            public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
                //Default implementation for test purposes
            }

            @Override
            public String getText() {
                return "Some Text"; // Return some placeholder text or actual text for testing
            }
        };
        this.slideBuilder.appendItem(testSlideItem);
        Slide slide = this.slideBuilder.build();
        assertTrue(slide.getSlideComponents().contains(testSlideItem));
    }
}