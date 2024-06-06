package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.utils.ValidationUtils;
import com.softwarequality.jabberpoint.XMLAccessor;
import com.softwarequality.jabberpoint.Constants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MenuController extends MenuBar {
    private final Frame parent;
    private final Presentation presentation;
    private final Map<String, Command> commands = new HashMap<>();

    public MenuController(Frame frame, Presentation presentation) {
        ValidationUtils.checkNotNull(frame, "Missing frame menu controller");
        ValidationUtils.checkNotNull(presentation, "Missing presentation facade parameter");

        this.parent = frame;
        this.presentation = presentation;
        initializeCommands();
        createMenus();
    }

    private void initializeCommands() {
        commands.put("OPEN", new OpenCommand(presentation, parent, new XMLAccessor(), new Constants("constants.json")));
        commands.put("NEW", new NewCommand(presentation, parent));
        commands.put("SAVE", new SaveCommand(presentation, parent, new XMLAccessor(), new Constants("constants.json")));
        commands.put("GOTO", new GotoCommand(presentation, parent, new Constants("constants.json")));
    }

    private void createMenus() {
        this.add(createFileMenu());
        this.add(createViewMenu());
        this.setHelpMenu(createHelpMenu());
    }

    private Menu createFileMenu() {
        Menu fileMenu = new Menu("File");
        fileMenu.add(createMenuItem("Open", commands.get("OPEN")));
        fileMenu.add(createMenuItem("New", commands.get("NEW")));
        fileMenu.add(createMenuItem("Save", commands.get("SAVE")));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Exit", e -> System.exit(0)));
        return fileMenu;
    }

    private Menu createViewMenu() {
        Menu viewMenu = new Menu("View");
        viewMenu.add(createMenuItem("Next", new NextSlideCommand(presentation)));
        viewMenu.add(createMenuItem("Prev", new PrevSlideCommand(presentation)));
        viewMenu.add(createMenuItem("Goto", commands.get("GOTO")));
        return viewMenu;
    }

    private Menu createHelpMenu() {
        Menu helpMenu = new Menu("Help");
        helpMenu.add(createMenuItem("About", e -> AboutBox.show(parent)));
        return helpMenu;
    }

    private MenuItem createMenuItem(String name, Command command) {
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(e -> command.execute());
        return menuItem;
    }

    private MenuItem createMenuItem(String name, ActionListener listener) {
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(listener);
        return menuItem;
    }
}
