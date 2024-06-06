package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AccessorTest {

    @Test
    public void testGetDemoAccessorReturnsDemoPresentationInstance() {
        Accessor accessor = Accessor.getDemoAccessor();
        assertInstanceOf(DemoPresentation.class, accessor);
    }

    @Test
    void testLoadFile() {
        Accessor accessor = Accessor.getDemoAccessor();
        Presentation presentation = new Presentation();

        try {
            accessor.loadFile(presentation, "fileName");
            Assertions.assertTrue(true);
        } catch (IOException e) {
            Assertions.fail("Failed to load file", e);
        }
    }

    @Test
    void testSaveFileThrowsException() {
        Accessor accessor = Accessor.getDemoAccessor();
        Presentation presentation = new Presentation();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            accessor.saveFile(presentation, "fileName");
        });
    }

}