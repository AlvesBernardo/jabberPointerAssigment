//package com.softwarequality.jabberpoint.drawer;
//
//import com.softwarequality.jabberpoint.slide.Style;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.verify;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class BitmapItemDrawerTest {
//	@Mock
//	private Graphics mockGraphics;
//	@Mock
//	private BufferedImage mockBufferedImage;
//	@Mock
//	private BitmapItem mockBitmapItem;
//	@Mock
//	private Style mockStyle;
//	@Mock
//	private ImageObserver mockObserver;
//
//	private BitmapItemDrawer drawerUnderTest;
//
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	void testDraw() {
//		// setup
//		int x = 10;
//		int y = 10;
//		float scale = 1.0f;
//		drawerUnderTest = new BitmapItemDrawer(mockBitmapItem);
//
//		// when
//		drawerUnderTest.draw(x, y, scale, mockGraphics, mockStyle, mockObserver);
//
//		// then
//		verify(mockGraphics).drawImage(
//				eq(mockBufferedImage),
//				anyInt(),
//				anyInt(),
//				anyInt(),
//				anyInt(),
//				eq(mockObserver)
//		);
//	}
//
//
//}