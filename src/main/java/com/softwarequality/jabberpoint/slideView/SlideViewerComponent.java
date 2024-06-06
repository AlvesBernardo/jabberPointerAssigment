package com.softwarequality.jabberpoint.slideView;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideConstants;
import com.softwarequality.jabberpoint.utils.ValidationUtils;
import com.softwarequality.jabberpoint.utils.CustomObservable;

import javax.swing.*;
import java.awt.*;

public class SlideViewerComponent extends JComponent {
  private static final long serialVersionUID = 227L;
  private static final Color BGCOLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 20;

  private final CustomObservable<Slide> observable = new CustomObservable<>();

  private Slide slide;
  private Font labelFont;
  private Presentation presentation;
  private JFrame frame;

  public SlideViewerComponent(Presentation presentation, JFrame frame) {
    ValidationUtils.checkNotNull(presentation, "Missing presentation in slide view component");
    ValidationUtils.checkNotNull(frame, "Missing frame in slide view component");

    setBackground(BGCOLOR);
    setPresentation(presentation);
    labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    setFrame(frame);
    new ComponentSlideObserver(this);
  }

  public Slide getSlide() {
    return this.slide;
  }

  public void setSlide(Slide slide) {
    ValidationUtils.checkNotNull(slide, "Missing slide in slide view component");
    this.slide = slide;
    this.observable.notifyObservers(slide);
  }

  public void setPresentation(Presentation presentation) {
    ValidationUtils.checkNotNull(presentation, "Missing presentation in slide view component");
    this.presentation = presentation;
  }

  public JFrame getFrame() {
    return this.frame;
  }

  public void setFrame(JFrame frame) {
    ValidationUtils.checkNotNull(frame, "Missing frame in slide view component");
    this.frame = frame;
  }

  public CustomObservable<Slide> getObservable() {
    return this.observable;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(SlideConstants.WIDTH, SlideConstants.HEIGHT);
  }

  public Presentation getPresentation() {
    return presentation;
  }

  public void update(Presentation presentation, Slide data) {
    ValidationUtils.checkNotNull(presentation, "Missing presentation in slide view component");

    this.presentation = presentation;
    this.slide = data;
    this.observable.notifyObservers(slide);
    repaint();
    frame.setTitle(presentation.getTitle());
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    ValidationUtils.checkNotNull(graphics, "Missing graphics in component");

    graphics.setColor(BGCOLOR);
    graphics.fillRect(0, 0, getSize().width, getSize().height);

    if (presentation.getSlideNumber() < 0 || slide == null) {
      return;
    }

    graphics.setFont(labelFont);
    graphics.setColor(COLOR);
    graphics.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(), XPOS, YPOS);
    Rectangle area = new Rectangle(0, YPOS, getWidth(), getHeight() - YPOS);
    slide.draw(graphics, area, this);
  }
}
