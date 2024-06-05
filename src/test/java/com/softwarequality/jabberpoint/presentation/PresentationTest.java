package com.softwarequality.jabberpoint.presentation;

import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest {
    private Presentation presentation;
    private Slide slide1;
    private Slide slide2;

    @BeforeEach
    public void setUp() {
        presentation = new Presentation();

        SlideBuilder slideBuilder = new SlideBuilder();

        slide1 = slideBuilder.withTitle("Test title 1").build();

        slide2 = slideBuilder.withTitle("Test title 2").build();

        presentation.appendSlide(slide1);
        presentation.appendSlide(slide2);
    }

    @Test
    public void testGetSize() {
        assertEquals(2, presentation.getSize());
    }

    @Test
    public void testGetSetTitle() {
        String title = "TestTitle";
        presentation.setTitle(title);
        assertEquals(title, presentation.getTitle());
    }

    @Test
    public void testSetTitleNull() {
        assertThrows(IllegalArgumentException.class, () -> presentation.setTitle(null));
    }

    @Test
    public void testGetSetSlideNumber() {
        presentation.setSlideNumber(1);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlid() {
        presentation.setSlideNumber(1);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide() {
        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testClear() {
        presentation.clear();
        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testAppendSlide() {
        SlideBuilder slideBuilder = new SlideBuilder();
        Slide slide3 = slideBuilder.withTitle("Test title 3").build();
        presentation.appendSlide(slide3);
        assertEquals(3, presentation.getSize());
    }

    @Test
    public void testGetSlide() {
        assertSame(slide2, presentation.getSlide(1));
    }

    @Test
    public void testGetCurrentSlide() {
        presentation.setSlideNumber(1);
        assertSame(slide2, presentation.getCurrentSlide());
    }

}