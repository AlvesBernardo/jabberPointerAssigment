package com.softwarequality.jabberpoint.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void testCheckNotNullWithNonNullObject() {
        Object obj = new Object();
        assertDoesNotThrow(() -> ValidationUtils.checkNotNull(obj, "Error message"));
    }

    @Test
    void testCheckNotNullWithNullObject() {
        Object obj = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ValidationUtils.checkNotNull(obj, "Error message"));
        assertEquals("Error message", exception.getMessage());
    }
}
