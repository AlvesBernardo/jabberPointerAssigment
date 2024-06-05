package com.softwarequality.jabberpoint.drawer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextItemTest {

    private TextItem textItem;

    @BeforeEach
    void setUp() {
        textItem = new TextItem(1, "Initial Text");
    }

    @Test
    void testSetText() {
        String newText = "New Text";
        textItem.setText(newText);
        assertEquals(newText, textItem.getText());
    }

}