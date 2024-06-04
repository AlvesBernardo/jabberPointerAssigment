//package com.softwarequality.jabberpoint;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.slide.Slide;
//import com.softwarequality.jabberpoint.slide.SlideBuilder;
//
//import java.io.File;
//import java.io.IOException;
//
//public class XMLAccessorTest
//{
//	private final String path = "src/test/resources/test.xml";
//	File file = new File(path);
//	String absolutePath = file.getAbsolutePath();
//	private XMLAccessor accessor;
//	private String TEST_FILE_PATH;
//
//	@BeforeEach
//	void setUp()
//	{
//		String path = "jabberPointerAssigment/src/test/resources/testPresentation.xml";
//		File file = new File(path);
//		TEST_FILE_PATH = file.getAbsolutePath();
//		accessor = new XMLAccessor();
//	}
//
//	@Test
//	void testLoadFile()
//	{
//		Presentation presentation = new Presentation();
//		try
//		{
//			accessor.loadFile(presentation, TEST_FILE_PATH);
//		} catch (IOException e)
//		{
//			fail("LoadFile threw an exception: " + e.getMessage());
//		}
//
//		assertNotNull(presentation.getTitle(), "Presentation title shouldn't be null");
//		assertNotEquals(0, presentation.getSize(), "Presentation should have slides");
//	}
//
//	@Test
//	void testSaveFile()
//	{
//		Presentation presentation = new Presentation();
//		presentation.setTitle("Test Presentation");
//
//		Slide slide = new SlideBuilder().withTitle("Test Slide").build();
//		presentation.appendSlide(slide);
//
//		try
//		{
//			accessor.saveFile(presentation, TEST_FILE_PATH);
//		} catch (IOException e)
//		{
//			fail("SaveFile threw an exception: " + e.getMessage());
//		}
//
//		Presentation loadedPresentation = new Presentation();
//		try
//		{
//			accessor.loadFile(loadedPresentation, TEST_FILE_PATH);
//		} catch (IOException e)
//		{
//			fail("LoadFile threw an exception: " + e.getMessage());
//		}
//		assertEquals(presentation.getSize(), loadedPresentation.getSize(),
//				"The number of slides in the saved and loaded presentations should be equal");
//		assertEquals(presentation.getTitle(), loadedPresentation.getTitle(),
//				"The titles of the saved and loaded presentations should be equal");
//	}
//}