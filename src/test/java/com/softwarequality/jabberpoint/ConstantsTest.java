package com.softwarequality.jabberpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstantsTest {

    private Constants constants;

    @BeforeEach
    void setUp() {
        constants = new Constants("constants.json");
    }

    @Test
    void testMissingFile() {
        assertThrows(IllegalArgumentException.class, () -> new Constants("missing_file.json"));
    }

    @Test
    void testInvalidKey() {
        assertThrows(org.json.JSONException.class, () -> constants.getValue("invalid_key"));
    }
}
