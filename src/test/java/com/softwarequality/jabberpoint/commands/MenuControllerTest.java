package com.softwarequality.jabberpoint.commands;
import com.softwarequality.jabberpoint.commands.*;
import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuControllerTest {

    private Frame parent;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        parent = Mockito.mock(Frame.class);
        presentation = Mockito.mock(Presentation.class);
    }

    @Test
    void createFileMenu() {
        MenuController mc = new MenuController(parent, presentation);
        Menu fileMenu = mc.getMenu(0);
        assertEquals("File", fileMenu.getLabel());
    }

    @Test
    void createViewMenu() {
        MenuController mc = new MenuController(parent, presentation);
        Menu viewMenu = mc.getMenu(1);
        assertEquals("View", viewMenu.getLabel());
    }

    @Test
    void createHelpMenu() {
        MenuController mc = new MenuController(parent, presentation);
        Menu helpMenu = mc.getHelpMenu();
        assertEquals("Help", helpMenu.getLabel());
    }

    @Test
    void createFileMenuTest() {
        MenuController menuController = new MenuController(parent, presentation);
        Menu fileMenu = menuController.getMenu(0);
        assertEquals("File", fileMenu.getLabel());

        MenuItem openMenuItem = fileMenu.getItem(0);
        assertEquals("Open", openMenuItem.getLabel());

        MenuItem newMenuItem = fileMenu.getItem(1);
        assertEquals("New", newMenuItem.getLabel());

        MenuItem saveMenuItem = fileMenu.getItem(2);
        assertEquals("Save", saveMenuItem.getLabel());
    }
}