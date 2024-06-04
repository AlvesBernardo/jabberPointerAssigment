package com.softwarequality.jabberpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstantsTest {

    private Constants constants;

    @BeforeEach
    void setUp() {
        constants = new Constants("constants.json");
    }

//    @Test
//    void testGetValue() {
//        // Test getting values by keys from the loaded JSON file
//        assertEquals("value1", constants.getValue("key1"));
//        assertEquals("value2", constants.getValue("key2"));
//        assertEquals("value3", constants.getValue("key3"));
//    }

    @Test
    void testMissingFile() {
        // Test loading a missing file
        assertThrows(IllegalArgumentException.class, () -> new Constants("missing_file.json"));
    }

    @Test
    void testInvalidKey() {
        // Test getting a value for an invalid key
        assertThrows(org.json.JSONException.class, () -> constants.getValue("invalid_key"));
    }
}
