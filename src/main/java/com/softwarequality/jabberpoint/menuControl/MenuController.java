package com.softwarequality.jabberpoint.menuControl;

import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.XMLAccessor;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class MenuController extends MenuBar {
    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PAGENR = "Page number?";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";
    protected static final String TESTFILE = "test.xml";
    protected static final String SAVEFILE = "dump.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";
    private static final long serialVersionUID = 227L;
    private final Frame parent;
    private final PresentationFacade presentation;
    private final Accessor xmlAccessor = new XMLAccessor();

    public MenuController(Frame frame, PresentationFacade presentationFacade) {
        this.validateInputs(frame, presentationFacade);
        this.parent = frame;
        this.presentation = presentationFacade;

        this.createMenus();
    }

    private void validateInputs(Frame frame, PresentationFacade presentationFacade) {
        if (frame == null) {
            throw new IllegalArgumentException("Missing frame menu controller");
        }
        if (presentationFacade == null) {
            throw new IllegalArgumentException("Missing presentation facade parameter");
        }
    }

    private void createMenus() {
        this.add(this.createFileMenu());
        this.add(this.createViewMenu());
        this.setHelpMenu(this.createHelpMenu()); // needed for portability (Motif, etc.).
    }

    private Menu createFileMenu() {
        Menu fileMenu = new Menu(FILE);
        fileMenu.add(createMenuItem(OPEN, this::openAction));
        fileMenu.add(createMenuItem(NEW, this::newAction));
        fileMenu.add(createMenuItem(SAVE, this::saveAction));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(EXIT, e -> this.presentation.exit()));
        return fileMenu;
    }

    private Menu createViewMenu() {
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(createMenuItem(NEXT, e -> this.presentation.nextSlide()));
        viewMenu.add(createMenuItem(PREV, e -> this.presentation.previousSlide()));
        viewMenu.add(createMenuItem(GOTO, this::gotoAction));
        return viewMenu;
    }

    private Menu createHelpMenu() {
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(createMenuItem(ABOUT, e -> AboutBox.show(this.parent)));
        return helpMenu;
    }

    private MenuItem createMenuItem(String name, ActionListener listener) {
        if (name == null) {
            throw new RuntimeException("Missing name in menu controller");
        }
        if (listener == null) {
            throw new RuntimeException("Missing listener in menu controller");
        }
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(listener);
        return menuItem;
    }

    private void openAction(ActionEvent actionEvent) {
        if (actionEvent == null) {
            throw new RuntimeException("Missing event in menu controller");
        }
        this.presentation.clear();
        try {
            xmlAccessor.loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            showErrorMessage(IOEX + exc, LOADERR);
        }

        this.parent.repaint();
    }

    private void newAction(ActionEvent actionEvent) {
        if (actionEvent == null) {
            throw new RuntimeException("Missing actionEvent too add action");
        }
        this.presentation.clear();
        this.parent.repaint();
    }

    private void saveAction(ActionEvent actionEvent) {
        if (actionEvent == null) {
            throw new RuntimeException("Missing actionEvent to save action");
        }
        try {
            this.xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            showErrorMessage(IOEX + exc, SAVEERR);
        }
    }

    private void gotoAction(ActionEvent actionEvent) {
        if (actionEvent == null) {
            throw new RuntimeException("Missing actionEvent to go to action");
        }
        String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
        int pageNumber = Integer.parseInt(pageNumberStr);
        this.presentation.setSlideNumber(pageNumber - 1);
    }

    private void showErrorMessage(String message, String title) {
        if (message == null) {
            throw new RuntimeException("Missing message to show error");
        }
        if (title == null) {
            throw new RuntimeException("Missing tittle to show error");
        }
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
