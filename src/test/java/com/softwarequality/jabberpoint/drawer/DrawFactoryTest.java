package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.utils.ImageLoadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrawFactoryTest {
	private DrawerFactory factory;

	@BeforeEach
	void setUp() {
		factory = new DrawerFactory();
	}

	@Test
	void testCreateDrawerForTextItem() {
		SlideItem item = new TextItem(1, "Test");
		Drawer drawer = factory.createDrawer(item);
		assertTrue(drawer instanceof TextItemDrawer);
	}

}