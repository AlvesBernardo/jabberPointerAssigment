package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.keyController.KeyController;
import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.menuControl.MenuController;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

public class SlideViewerFrame extends JFrame {
	private static final long serialVersionUID = 3227L;

	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

	public SlideViewerFrame(String title, PresentationFacade presentationFacade) {
		super(title);
		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentationFacade, this);
		presentationFacade.setShowView(slideViewerComponent);
		setupWindow(slideViewerComponent, presentationFacade);
	}

	public void setupWindow(SlideViewerComponent slideViewerComponent, PresentationFacade presentationFacade) {
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(presentationFacade));
		setMenuBar(new MenuController(this, presentationFacade));
		setSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
	}
}
