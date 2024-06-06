package com.softwarequality.jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

class SlideImplementationTest {
    private SlideImplementation slideImplementation;
    private SlideImplementation slideImplementation2;

    @BeforeEach
    void setUp() {
        this.slideImplementation = new SlideImplementation();
    }


    @Test
    void givenTitleWhenSetTitleThenSlideTitleIsSet() {
        SlideComponent titleSlideComponent = new SlideComponent() {
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
                return "Test Title"; // Default implementation for test purposes
            }
        };
        this.slideImplementation.setTitle(titleSlideComponent);
        assertEquals("Test Title", this.slideImplementation.getTitle());
    }

    @Test
    void givenNullSlideItemWhenAppendItemThenThrowException() {
        assertThrows(IllegalStateException.class, () -> this.slideImplementation.appendItem(null));
    }

    @Test
    void givenSlideComponentWhenAppendItemThenSlideComponentIsAdded() {
        SlideComponent testSlideComponent = new SlideComponent() {
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
                return "Test Component"; // Default implementation for test purposes
            }
        };
        this.slideImplementation.appendItem(testSlideComponent);
        assertTrue(this.slideImplementation.getSlideComponents().contains(testSlideComponent));
    }

}