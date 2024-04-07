package com.softwarequality.jabberpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccessorTest {

    @Test
    public void testGetDemoAccessorReturnsDemoPresentationInstance() {
        Accessor accessor = Accessor.getDemoAccessor();
        assertTrue(accessor instanceof DemoPresentation);
    }

}