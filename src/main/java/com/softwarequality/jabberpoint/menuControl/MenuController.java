package com.softwarequality.jabberpoint.menuControl;

import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.XMLAccessor;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;


public class MenuController extends MenuBar {
	private Frame parent;
	private PresentationFacade presentation;
	private Accessor xmlAccessor = new XMLAccessor();

	private static final long serialVersionUID = 227L;
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

	public MenuController(Frame frame, PresentationFacade pres) {
		parent = frame;
		presentation = pres;

		Menu fileMenu = new Menu(FILE);
		fileMenu.add(createMenuItem(OPEN, this::openAction));
		fileMenu.add(createMenuItem(NEW, this::newAction));
		fileMenu.add(createMenuItem(SAVE, this::saveAction));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem(EXIT, e -> presentation.exit()));
		add(fileMenu);

		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(createMenuItem(NEXT, e -> presentation.nextSlide()));
		viewMenu.add(createMenuItem(PREV, e -> presentation.previousSlide()));
		viewMenu.add(createMenuItem(GOTO, this::gotoAction));
		add(viewMenu);

		Menu helpMenu = new Menu(HELP);
		helpMenu.add(createMenuItem(ABOUT, e -> AboutBox.show(parent)));
		setHelpMenu(helpMenu); // needed for portability (Motif, etc.).
	}

	private MenuItem createMenuItem(String name, ActionListener listener) {
		MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
		menuItem.addActionListener(listener);
		return menuItem;
	}

	private void openAction(ActionEvent actionEvent) {
		presentation.clear();
		try {
			xmlAccessor.loadFile(presentation, TESTFILE);
			presentation.setSlideNumber(0);
		} catch (IOException exc) {
			showErrorMessage(IOEX + exc, LOADERR);
		}

		parent.repaint();
	}

	private void newAction(ActionEvent actionEvent) {
		presentation.clear();
		parent.repaint();
	}

	private void saveAction(ActionEvent actionEvent) {
		try {
			xmlAccessor.saveFile(presentation, SAVEFILE);
		} catch (IOException exc) {
			showErrorMessage(IOEX + exc, SAVEERR);
		}
	}

	private void gotoAction(ActionEvent actionEvent) {
		String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
		int pageNumber = Integer.parseInt(pageNumberStr);
		presentation.setSlideNumber(pageNumber - 1);
	}

	private void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
	}
}
