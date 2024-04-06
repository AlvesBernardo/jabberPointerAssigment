package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.ImageLoadingException;
import com.softwarequality.jabberpoint.slide.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class BitmapItemTest {
    private BitmapItem bitmapItem;
    private String imageName = "testImage.png";
    private int level = 2;
    private BufferedImage testBufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    @BeforeEach
    public void setup() throws ImageLoadingException {
        bitmapItem = new BitmapItem(level, imageName);
    }

    @Test
    public void testConstructor() {
        assertNotNull(bitmapItem);
        assertEquals(level, bitmapItem.getLevel());
        assertEquals(imageName, bitmapItem.getImageName());
    }

    @Test
    public void testSetImageName() {
        String newImageName = "newImage.png";
        bitmapItem.setImageName(newImageName);
        assertEquals(newImageName, bitmapItem.getImageName());
    }

    @Test
    public void testSetImageNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            bitmapItem.setImageName(null);
        });
    }

    @Test
    public void testSetBufferedImage() {
        bitmapItem.setBufferedImage(testBufferedImage);
        assertEquals(testBufferedImage, bitmapItem.getBufferedImage());
    }

    @Test
    public void testSetBufferedImageNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            bitmapItem.setBufferedImage(null);
        });
    }

    @Test
    public void testGetBoundingBox() {
        Style style = new Style(10, Color.white, 1, 1);
        ImageObserver observer = null;
        Graphics graphics = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB).getGraphics();

        final int testLevel = level;
        final String testImageName = "non_existent.png";
        Throwable exception = assertThrows(ImageLoadingException.class, () -> new BitmapItem(testLevel, testImageName));
        assertEquals("File " + testImageName + " not found", exception.getMessage());

        observer = new Canvas();

        assertNotNull(bitmapItem.getBoundingBox(graphics, observer, 2.0f, style));
    }

    @Test
    public void testDraw() {
        Style style = new Style(10, Color.white, 1, 1);
        ImageObserver observer = new Canvas();
        Graphics graphics = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB).getGraphics();

        // Should not throw an Exception
        bitmapItem.draw(10, 10, 2.0f, graphics, style, observer);
    }

    @Test
    public void testGetText() {
        assertNull(bitmapItem.getText());
    }

    @Test
    public void testToString() {
        assertTrue(bitmapItem.toString().contains(imageName));
        assertTrue(bitmapItem.toString().contains(String.valueOf(level)));
    }

    @Test
    public void testGetImage() {
        assertNotNull(bitmapItem.getImage());
    }

    // This test assumes that the image file doesn't exist, so it should throw an exception
    @Test
    public void testLoadImageNonExistentFileThrowsException() {
        Throwable exception = assertThrows(ImageLoadingException.class, () -> new BitmapItem(level, "non_existent.png"));
        assertEquals("File non_existent.png not found", exception.getMessage());
    }
}