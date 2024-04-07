package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideConstants;
import java.awt.*;
import java.util.Observable;
import javax.swing.*;

public class SlideViewerComponent extends JComponent {

  private static final long serialVersionUID = 227L;
  private static final Color BGCOLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 20;
  private final Observable observable =
      new Observable() {
        @Override
        public void notifyObservers() {
          setChanged();
          super.notifyObservers();
        }
      };
  private Slide slide;
  private Font labelFont = null;
  private PresentationFacade presentation = null;
  private JFrame frame = null;

  public SlideViewerComponent(PresentationFacade presentation, JFrame frame) {
    setBackground(BGCOLOR);
    setPresentation(presentation);
    labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    setFrame(frame);
    // Add observer
    observable.addObserver(new ComponentSlideObserver(this));
  }

  public Slide getSlide() {
    return this.slide;
  }

  public void setSlide(Slide slide) {
    if (slide == null) {
      throw new IllegalStateException("missing slide in slide view component");
    }
    this.slide = slide;
  }

  public Font getLabelFont() {
    return this.labelFont;
  }

  public void setLabelFont(Font labelFont) {
    if (labelFont == null) {
      throw new IllegalStateException("missing Font in slide view component");
    }
    this.labelFont = labelFont;
  }

  public void setPresentation(PresentationFacade presentation) {
    if (presentation == null) {
      throw new IllegalStateException("missing presentation in slide view component");
    }
    this.presentation = presentation;
  }

  public JFrame getFrame() {
    return this.frame;
  }

  public void setFrame(JFrame frame) {
    if (frame == null) {
      throw new IllegalStateException("missing frame in slide view component");
    }
    this.frame = frame;
  }

  public Observable getObservable() {
    return this.observable;
  }

  public Dimension getPreferredSize() {

    return new Dimension(SlideConstants.WIDTH, SlideConstants.HEIGHT);
  }

  public PresentationFacade getPresentation() {
    return presentation;
  }

  public void update(PresentationFacade presentationFacade, Slide data) {
    if (presentationFacade == null) {
      throw new IllegalStateException("Missing facade in slide view componet");
    }
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

  public void paintComponent(Graphics graphics) {
    if (graphics == null) {
      throw new IllegalStateException("Missing graphics in componet");
    }
    graphics.setColor(BGCOLOR);
    graphics.fillRect(0, 0, getSize().width, getSize().height);
    if (presentation.getSlideNumber() < 0 || slide == null) {
      return;
    }
    graphics.setFont(labelFont);
    graphics.setColor(COLOR);
    graphics.drawString(
        "Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(),
        XPOS,
        YPOS);
    Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
    slide.draw(graphics, area, this);
  }
}
