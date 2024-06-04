package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DemoPresentationTest {
	Accessor accessor;
	Presentation presentation;

	@BeforeEach
	void setUp() {
		accessor = Accessor.getDemoAccessor();
		presentation = new Presentation();
	}

//	@Test
//	void testLoadFileAddsSlides() {
//		try {
//			accessor.loadFile(presentation, null);
//			Assertions.assertEquals(3, presentation.getSize());
//			Assertions.assertEquals("Demo Presentation", presentation.getTitle());
//		} catch (IOException e) {
//			Assertions.fail("IOException should not have been thrown.", e);
//		}
//	}

	@Test
	void testLoadFileWithNullPresentationShouldThrowException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			accessor.loadFile(null, null);
		});
	}

	@Test
	void testSaveFileException() {
		Assertions.assertThrows(IllegalStateException.class, () -> {
			accessor.saveFile(new Presentation(), "test");
		});
	}
}