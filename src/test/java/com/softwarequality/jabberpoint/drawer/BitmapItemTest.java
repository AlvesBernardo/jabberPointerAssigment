package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.utils.ImageLoadingException;
import com.softwarequality.jabberpoint.utils.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BitmapItemTest {

    private BitmapItem bitmapItem;
    private String imageName;
    private BufferedImage bufferedImage;

    @BeforeEach
    void setUp() {
        imageName = "testImage.png";
    }

//    @Test
//    void testConstructorAndLoadImageSuccess() throws ImageLoadingException, IOException {
//        // Mock the File and ImageIO to simulate image loading
//        File mockFile = mock(File.class);
//        when(mockFile.exists()).thenReturn(true);
//
//        bufferedImage = mock(BufferedImage.class);
//        mockStatic(ImageIO.class);
//        when(ImageIO.read(any(File.class))).thenReturn(bufferedImage);
//
//        bitmapItem = new BitmapItem(1, imageName);
//        assertNotNull(bitmapItem.getBufferedImage());
//        assertEquals(imageName, bitmapItem.getImageName());
//    }

    @Test
    void testConstructorAndLoadImageFailure() {
        // Simulate a failure in loading the image
        assertThrows(ImageLoadingException.class, () -> new BitmapItem(1, "nonexistentImage.png"));
    }

//    @Test
//    void testSetBufferedImage() throws ImageLoadingException {
//        bufferedImage = mock(BufferedImage.class);
//        bitmapItem = new BitmapItem(1, imageName);
//        bitmapItem.setBufferedImage(bufferedImage);
//        assertEquals(bufferedImage, bitmapItem.getBufferedImage());
//    }

    @Test
    void testSetImageName() throws ImageLoadingException {
        bitmapItem = new BitmapItem(1, imageName);
        bitmapItem.setImageName("newImage.png");
        assertEquals("newImage.png", bitmapItem.getImageName());
    }

//    @Test
//    void testGetBoundingBox() throws ImageLoadingException {
//        Graphics graphics = mock(Graphics.class);
//        ImageObserver observer = mock(ImageObserver.class);
//        Style style = mock(Style.class);
//        when(style.getIndent()).thenReturn(20);
//        when(style.getLeading()).thenReturn(10);
//
//        bufferedImage = mock(BufferedImage.class);
//        when(bufferedImage.getWidth(observer)).thenReturn(100);
//        when(bufferedImage.getHeight(observer)).thenReturn(50);
//
//        bitmapItem = new BitmapItem(1, imageName);
//        bitmapItem.setBufferedImage(bufferedImage);
//
//        Rectangle boundingBox = bitmapItem.getBoundingBox(graphics, observer, 1.0f, style);
//        assertEquals(new Rectangle(20, 0, 100, 60), boundingBox);
//    }

//    @Test
//    void testDraw() throws ImageLoadingException {
//        Graphics graphics = mock(Graphics.class);
//        ImageObserver observer = mock(ImageObserver.class);
//        Style style = mock(Style.class);
//        when(style.getIndent()).thenReturn(20);
//        when(style.getLeading()).thenReturn(10);
//
//        bufferedImage = mock(BufferedImage.class);
//        when(bufferedImage.getWidth(observer)).thenReturn(100);
//        when(bufferedImage.getHeight(observer)).thenReturn(50);
//
//        bitmapItem = new BitmapItem(1, imageName);
//        bitmapItem.setBufferedImage(bufferedImage);
//
//        bitmapItem.draw(10, 10, 1.0f, graphics, style, observer);
//        verify(graphics).drawImage(eq(bufferedImage), eq(30), eq(20), eq(100), eq(50), eq(observer));
//    }

    @Test
    void testValidation() throws ImageLoadingException {
        bitmapItem = new BitmapItem(1, imageName);

        // Test validation for null BufferedImage
        assertThrows(IllegalArgumentException.class, () -> bitmapItem.setBufferedImage(null));

        // Test validation for null ImageName
        assertThrows(IllegalArgumentException.class, () -> bitmapItem.setImageName(null));
    }
}
