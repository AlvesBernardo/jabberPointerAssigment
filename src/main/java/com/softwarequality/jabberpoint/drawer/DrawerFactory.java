package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.slide.SlideItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DrawerFactory {
    private final Map<Class<? extends SlideItem>, Function<SlideItem, Drawer>> drawerSuppliers = new HashMap<>();

    public DrawerFactory() {
        drawerSuppliers.put(TextItem.class, item -> new TextItemDrawer((TextItem) item));
        drawerSuppliers.put(BitmapItem.class, item -> new BitmapItemDrawer((BitmapItem) item));
    }

    public Drawer createDrawer(SlideItem item) {
        Function<SlideItem, Drawer> supplier = drawerSuppliers.get(item.getClass());
        if (supplier == null) {
            throw new IllegalArgumentException("No drawer for SlideItem: " + item.getClass().getSimpleName());
        }
        return supplier.apply(item);
    }
}
