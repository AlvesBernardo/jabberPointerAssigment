package com.softwarequality.jabberpoint.utils;

import com.softwarequality.jabberpoint.slide.Style;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphicsUtilsTest {

    @Test
    void testInitializePen() {
        // Given
        int x = 10;
        int y = 20;
        float scale = 1.5f;
        // Create a Style instance with default color (null)
        Style style = new Style(5, null, 10, 0);

        // When
        Point pen = GraphicsUtils.initializePen(x, y, scale, style);

        // Then
        int expectedPenX = x + (int) (style.getIndent() * scale);
        int expectedPenY = y + (int) (style.getLeading() * scale);
        assertEquals(expectedPenX, pen.x);
        assertEquals(expectedPenY, pen.y);
    }
}
