package com.softwarequality.jabberpoint.commands;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutBoxTest {

    @Test
    public void testShow() {
        JFrame parentFrame = new JFrame();
        AboutBox.show(parentFrame);
        assertTrue(true);
    }
}
