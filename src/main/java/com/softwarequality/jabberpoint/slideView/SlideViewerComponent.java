package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.Observable;

public class SlideViewerComponent extends JComponent {

	private Slide slide;
	private Font labelFont = null;
	private PresentationFacade presentation = null;
	private JFrame frame = null;
	private static final long serialVersionUID = 227L;
	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	private Observable observable = new Observable() {
		@Override
		public void notifyObservers() {
			setChanged();
			super.notifyObservers();
		}
	};

	public SlideViewerComponent(PresentationFacade pres, JFrame frame) {
		setBackground(BGCOLOR);
		presentation = pres;
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = frame;
		// Add observer
		observable.addObserver(new ComponentSlideObserver(this));
	}

	public Dimension getPreferredSize() {
		return new Dimension(SlideConstants.WIDTH, SlideConstants.HEIGHT);
	}

	public PresentationFacade getPresentation() {
		return presentation;
	}

	public void update(PresentationFacade presentationFacade, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentationFacade;
		this.slide = data;
		this.observable.notifyObservers(slide);
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	public void paintComponent(Graphics g) {
		g.setColor(BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(labelFont);
		g.setColor(COLOR);
		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
                 presentation.getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(g, area, this);
	}

}
