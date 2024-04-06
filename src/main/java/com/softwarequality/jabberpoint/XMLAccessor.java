package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.drawer.BitmapItem;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideBuilder;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.slide.TextItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLAccessor extends Accessor {

  protected static final String DEFAULT_API_TO_USE = "dom";

  protected static final String SHOWTITLE = "showtitle";
  protected static final String SLIDETITLE = "title";
  protected static final String SLIDE = "slide";
  protected static final String ITEM = "item";
  protected static final String LEVEL = "level";
  protected static final String KIND = "kind";
  protected static final String TEXT = "text";
  protected static final String IMAGE = "image";

  protected static final String PCE = "Parser Configuration Exception";
  protected static final String UNKNOWNTYPE = "Unknown Element type";
  protected static final String NFE = "Number Format Exception";



  private String getTitle(Element element, String tagName) {
    if (tagName == null || element == null) {
      throw new RuntimeException("Missing parameter for get title in xml accessor");
    }
    NodeList titles = element.getElementsByTagName(tagName);
    return titles.item(0).getTextContent();
  }

  public void loadFile(PresentationFacade presentation, String filename) throws IOException {
    if (presentation == null || filename == null) {
      throw new RuntimeException("Missing parameter for load file in xml accessor");
    }

    try {
      Document document = createDocument(filename);
      Element doc = document.getDocumentElement();

      presentation.setTitle(getTitle(doc, SHOWTITLE));
      populateSlides(doc, presentation);

    } catch (IOException iox) {
      System.err.println(iox);
    } catch (SAXException sax) {
      System.err.println(sax.getMessage());
    } catch (ParserConfigurationException pcx) {
      System.err.println(PCE);
    } catch (ImageLoadingException e) {
      throw new RuntimeException(e);
    }
  }

  private Document createDocument(String filename) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    return builder.parse(new File(filename));
  }

  private void populateSlides(Element doc, PresentationFacade presentation) throws ImageLoadingException {
    NodeList slides = doc.getElementsByTagName(SLIDE);
    int slideNumber, max = slides.getLength();
    for (slideNumber = 0; slideNumber < max; slideNumber++) {
      Element xmlSlide = (Element) slides.item(slideNumber);
      Slide slide = createSlide(xmlSlide);
      presentation.appendSlide(slide);
    }
  }

  private Slide createSlide(Element xmlSlide) throws ImageLoadingException {
    SlideBuilder slideBuilder = new SlideBuilder().withTitle(getTitle(xmlSlide, SLIDETITLE));
    NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
    int itemNumber, maxItems = slideItems.getLength();
    for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
      Element item = (Element) slideItems.item(itemNumber);
      loadSlideItem(slideBuilder, item);
    }
    return slideBuilder.build();
  }

  protected void loadSlideItem(SlideBuilder slideBuilder, Element item)
      throws ImageLoadingException {
    int level = 1; // default
    NamedNodeMap attributes = item.getAttributes();
    String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
    if (leveltext != null) {
      try {
        level = Integer.parseInt(leveltext);
      } catch (NumberFormatException x) {
        System.err.println(NFE);
      }
    }
    String type = attributes.getNamedItem(KIND).getTextContent();
    if (TEXT.equals(type)) {
      slideBuilder.appendItem(new TextItem(level, item.getTextContent()));
    } else if (IMAGE.equals(type)) {
      slideBuilder.appendItem(new BitmapItem(level, item.getTextContent()));
    } else {
      System.err.println(UNKNOWNTYPE);
    }
  }

  public void saveFile(PresentationFacade presentation, String filename) throws IOException {
    if (presentation == null || filename == null) {
      throw new RuntimeException("Missing parameter for save file in xml accessor");
    }
    try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
      generateXML(out, presentation);
    }
  }

  private void generateXML(PrintWriter writer, PresentationFacade presentation) {
    writer.println("<?xml version=\"1.0\"?>");
    writer.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
    writer.println("<presentation>");
    writer.println("<showtitle>" + presentation.getTitle() + "</showtitle>");

    for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
      writeSlide(writer, presentation.getSlide(slideNumber));
    writer.println("</presentation>");
  }

  private void writeSlide(PrintWriter writer, Slide slide) {
    writer.println("<slide>");
    writer.println("<title>" + slide.getTitle() + "</title>");

    for (SlideItem slideItem : slide.getSlideItems())
      writeItem(writer, slideItem);

    writer.println("</slide>");
  }

  private void writeItem(PrintWriter writer, SlideItem slideItem) {
    writer.print("<item kind=");

    if (slideItem instanceof TextItem)
      writeTextItem(writer, (TextItem) slideItem);
    else if (slideItem instanceof BitmapItem)
      writeBitmapItem(writer, (BitmapItem) slideItem);
    else
      System.out.println("Ignoring " + slideItem);

    writer.println("</item>");
  }

  private void writeTextItem(PrintWriter writer, TextItem textItem) {
    writer.print("\"text\" level=\"" + textItem.getLevel() + "\">");
    writer.print(textItem.getText());
  }

  private void writeBitmapItem(PrintWriter writer, BitmapItem bitmapItem) {
    writer.print("\"image\" level=\"" + bitmapItem.getLevel() + "\">");
    writer.print(bitmapItem.getImageName());
  }
}
