//package com.softwarequality.jabberpoint.drawer;
//
//import com.softwarequality.jabberpoint.slide.Style;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//class BitmapItemDrawerTest {
//
//    private BitmapItemDrawer bitmapItemDrawer;
//    private BitmapItem bitmapItem;
//    private Graphics graphics;
//    private Style style;
//    private ImageObserver observer;
//
//    @BeforeEach
//    void setUp() {
//        bitmapItem = mock(BitmapItem.class);
//        graphics = mock(Graphics.class);
//        style = mock(Style.class);
//        observer = mock(ImageObserver.class);
//        bitmapItemDrawer = new BitmapItemDrawer(bitmapItem);
//    }
//
//    @Test
//    void testDraw() {
//        // Mocking bitmap item's properties
//        BufferedImage bufferedImage = mock(BufferedImage.class);
//        when(bufferedImage.getWidth(observer)).thenReturn(100);
//        when(bufferedImage.getHeight(observer)).thenReturn(50);
//        when(bitmapItem.getBufferedImage()).thenReturn(bufferedImage);
//
//        // Mocking style properties
//        when(style.getIndent()).thenReturn(20);
//        when(style.getLeading()).thenReturn(10);
//
//        // Execute the draw method
//        bitmapItemDrawer.draw(10, 10, 1.0f, graphics, style, observer);
//
//        // Verify that graphics.drawImage is called with the correct parameters
//        verify(graphics).drawImage(eq(bufferedImage), eq(10 + 20), eq(10), eq(100), eq(50), eq(observer));
//    }
//
//    @Test
//    void testNullInputs() {
//        assertThrows(IllegalArgumentException.class, () -> bitmapItemDrawer.draw(10, 10, 1.0f, null, style, observer));
//        assertThrows(IllegalArgumentException.class, () -> bitmapItemDrawer.draw(10, 10, 1.0f, graphics, null, observer));
//        assertThrows(IllegalArgumentException.class, () -> bitmapItemDrawer.draw(10, 10, 1.0f, graphics, style, null));
//        assertThrows(IllegalArgumentException.class, () -> new BitmapItemDrawer(null));
//    }
//}
