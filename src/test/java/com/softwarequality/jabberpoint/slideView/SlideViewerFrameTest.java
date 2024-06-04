//package com.softwarequality.jabberpoint.slideView;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.awt.event.WindowAdapter;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class SlideViewerFrameTest {
//
//	@Mock
//	Presentation presentation;
//
//	@Mock
//	SlideViewerComponent slideViewerComponent;
//
//	@Captor
//	ArgumentCaptor<WindowAdapter> windowAdapterCaptor;
//
//	SlideViewerFrame slideViewerFrame;
//	String title = "Test Title";
//
//	@BeforeEach
//	void setUp() {
//		slideViewerFrame = new SlideViewerFrame(title, presentation);
//	}
//
//	@Test
//	void testSetupWindow() {
//		// The Mockito extension injects Mocks and Captors into the tested class
//		verify(presentation).setShowView(slideViewerComponent);
//
//		// Verify addWindowListener called with any WindowAdapter and capture the argument
//		verify(slideViewerFrame).addWindowListener(windowAdapterCaptor.capture());
//		WindowAdapter windowAdapter = windowAdapterCaptor.getValue();
//
//		// Ensure that the WindowAdapter causes the application to exit when windowClosing is called
//		assertNotNull(windowAdapter);
//		assertDoesNotThrow(() -> windowAdapter.windowClosing(null));
//
//		assertEquals(title, slideViewerFrame.getTitle());
//	}
//}
