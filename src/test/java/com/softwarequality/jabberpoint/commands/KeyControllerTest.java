package com.softwarequality.jabberpoint.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyControllerTest {

    @Test
    public void ConstructerToThowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new KeyController(null);
        });
    }

}
