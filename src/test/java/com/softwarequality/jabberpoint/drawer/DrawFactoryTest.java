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
//
//	@Test
//	void testCreateDrawerForBitmapItem() {
//		try {
//			SlideItem item = new BitmapItem(1, "Test");
//			Drawer drawer = factory.createDrawer(item);
//
//			assertTrue(drawer instanceof BitmapItemDrawer);
//		} catch (ImageLoadingException e) {
//			e.printStackTrace();
//		}
//	}

//	@Test
//	void testCreateDrawerForUnknownItem() {
//		class OtherItem extends SlideItem {
//			OtherItem(int level, String text) { super(level, text); }
//		}
//		SlideItem item = new OtherItem(1, "Test");
//		assertThrows(IllegalArgumentException.class, () -> {
//			factory.createDrawer(item);
//		});
//	}
}