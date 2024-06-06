package com.softwarequality.jabberpoint.utils;

public class ValidationUtils
{
    public static void checkNotNull(Object obj, String errorMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
