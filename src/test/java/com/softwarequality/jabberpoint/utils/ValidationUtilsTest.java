package com.softwarequality.jabberpoint.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void testCheckNotNullWithNonNullObject() {
        // Test with a non-null object
        Object obj = new Object();
        assertDoesNotThrow(() -> ValidationUtils.checkNotNull(obj, "Error message"));
    }

    @Test
    void testCheckNotNullWithNullObject() {
        // Test with a null object
        Object obj = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.checkNotNull(obj, "Error message"));

        // Verify the error message
        assertEquals("Error message", exception.getMessage());
    }
}
