package com.softwarequality.jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.image.ImageObserver;
import com.softwarequality.jabberpoint.slide.Style;

import static org.junit.jupiter.api.Assertions.*;

class TextItemTest {


    private TextItem textItem;
    private Graphics graphics;
    private ImageObserver observer;
    private Style style;

    @BeforeEach
    void setUp() {
        this.textItem = new TextItem(1, "Test TextItem");
        this.graphics = new Canvas().getGraphics();  // default Canvas placed to get Graphics instance
        this.observer = new ImageObserver() {        // minimal ImageObserver implementation
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        };
        this.style =  new Style(10, Color.white, 12, 1);
    }
//
//    @Test
//    void givenValidParametersWhenGetBoundingBoxThenReturnRectangle() {
//        Rectangle result = this.textItem.getBoundingBox(graphics, observer, 1, style);
//        assertNotNull(result);
//    } coudl not run this goodle says ineed something like swing

    @Test
    void testSetTextAndGetText() {
        String newText = "New test text";
        this.textItem.setText(newText);
        assertEquals(newText, this.textItem.getText());
    }
}