//package com.softwarequality.jabberpoint.slideView;
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.slide.Slide;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import javax.swing.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class SlideViewerComponentTest {
//
//	@Mock
//	private Presentation presentation;
//
//	@Mock
//	private Slide slide;
//
//	private JFrame frame = new JFrame();
//
//	@InjectMocks
//	private SlideViewerComponent slideViewerComponent;
//
//	@BeforeEach
//	void setUp() {
//		slideViewerComponent.setPresentation(presentation);
//		slideViewerComponent.setSlide(slide);
//		slideViewerComponent.setFrame(frame);
//	}
//
//	@Test
//	void testUpdate() {
//		assertDoesNotThrow(() -> slideViewerComponent.update(presentation, slide));
//		verify(presentation).getTitle();
//	}
//
//	@Test
//	void testGetSlide() {
//		assertEquals(slide, slideViewerComponent.getSlide());
//	}
//
//	// Add more tests...
//}