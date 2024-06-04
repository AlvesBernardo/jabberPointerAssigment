package com.softwarequality.jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

class SlideItemTest {
    private SlideItem slideItem;

    @BeforeEach
    void setUp() {
        this.slideItem = new SlideItem(1) {
            @Override
            public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
                return new Rectangle(); // Default implementation for test purposes
            }
            @Override
            public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
                //Default implementation for test purposes
            }

            @Override
            public String getText() {
                return "Test text"; // Default implementation for test purposes
            }
        };
    }


    void givenSlideComponentWhenAddComponentThenItIsAddedToSlideComponents() {
        SlideComponent testSlideComponent = new SlideItem(1) {
            @Override
            public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
                // return default implementation for test purposes
                return new Rectangle();
            }

            @Override
            public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
                // default implementation for test purposes
            }

            @Override
            public String getText() {
                // default implementation for test purposes
                return "Test slide item";
            }
        };
        this.slideItem.addComponent(testSlideComponent);
        assertTrue(this.slideItem.getSlideComponents().contains(testSlideComponent));
    }

	@Test
	void givenNullSlideComponentWhenAddComponentThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> this.slideItem.addComponent(null));
	}

	@Test
	void givenNullSlideComponentWhenRemoveThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> this.slideItem.removeComponent(null));
	}

    @Test
    void givenLevelWhenSetLevelThenSlideLevelIsSet() {
        int newLevel = 2;
        this.slideItem.setLevel(newLevel);
        assertEquals(newLevel, this.slideItem.getLevel());
    }
}