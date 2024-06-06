package com.softwarequality.jabberpoint.drawer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextItemDrawerTest {

    private TextItemDrawer textItemDrawer;

    @Test
    void ConstructorThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            textItemDrawer = new TextItemDrawer(null);
        });
    }
}
