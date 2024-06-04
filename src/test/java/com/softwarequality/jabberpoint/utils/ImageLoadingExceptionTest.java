package com.softwarequality.jabberpoint.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ImageLoadingExceptionTest {

    @Test
    void testConstructorAndGetters() {
        // Create an instance of ImageLoadingException
        Throwable cause = new RuntimeException("Underlying cause");
        ImageLoadingException exception = new ImageLoadingException("Error message", cause);

        // Test the message and cause
        assertEquals("Error message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithNullCause() {
        // Create an instance of ImageLoadingException with null cause
        ImageLoadingException exception = new ImageLoadingException("Error message", null);

        // Test the message and cause
        assertEquals("Error message", exception.getMessage());
        assertNull(exception.getCause());
    }
}
