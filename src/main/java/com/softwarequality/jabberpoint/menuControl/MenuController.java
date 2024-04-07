package com.softwarequality.jabberpoint.menuControl;

import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.Constants;
import com.softwarequality.jabberpoint.XMLAccessor;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class MenuController extends MenuBar {
    Constants constants = new Constants("constants.json");
    String ABOUT = constants.getValue("ABOUT");
    String FILE = constants.getValue("FILE");
    String EXIT = constants.getValue("EXIT");
    String GOTO = constants.getValue("GOTO");
    String HELP = constants.getValue("HELP");
    String NEW = constants.getValue("NEW");
    String NEXT = constants.getValue("NEXT");
    String OPEN = constants.getValue("OPEN");
    String PAGENR = constants.getValue("PAGENR");
    String PREV = constants.getValue("PREV");
    String SAVE = constants.getValue("SAVE");
    String VIEW = constants.getValue("VIEW");
    String TESTFILE = constants.getValue("TESTFILE");
    String SAVEFILE = constants.getValue("SAVEFILE");
    String IOEX = constants.getValue("IOEX");
    String LOADERR = constants.getValue("LOADERR");
    String SAVEERR = constants.getValue("SAVEERR");
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
