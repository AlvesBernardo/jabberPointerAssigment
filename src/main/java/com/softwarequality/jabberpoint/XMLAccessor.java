package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideBuilder;
import com.softwarequality.jabberpoint.drawer.TextItem;
import com.softwarequality.jabberpoint.drawer.BitmapItem;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.utils.ValidationUtils;
import com.softwarequality.jabberpoint.utils.ImageLoadingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class XMLAccessor extends Accessor {
    private static final String SHOWTITLE = "showtitle";
    private static final String SLIDETITLE = "title";
    private static final String SLIDE = "slide";
    private static final String ITEM = "item";
    private static final String LEVEL = "level";
    private static final String KIND = "kind";
    private static final String TEXT = "text";
    private static final String IMAGE = "image";
    private static final String UNKNOWNTYPE = "Unknown Element type";
    private static final String NFE = "Number Format Exception";

    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();
    }

    @Override
    public void loadFile(Presentation presentation, String filename) throws IOException {
        ValidationUtils.checkNotNull(presentation, "Missing presentation in loadFile");
        ValidationUtils.checkNotNull(filename, "Missing filename in loadFile");

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, SHOWTITLE));

            NodeList slides = doc.getElementsByTagName(SLIDE);
            for (int slideNumber = 0; slideNumber < slides.getLength(); slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);
                SlideBuilder slideBuilder = new SlideBuilder().withTitle(getTitle(xmlSlide, SLIDETITLE));

                NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
                for (int itemNumber = 0; itemNumber < slideItems.getLength(); itemNumber++) {
                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(slideBuilder, item);
                }

                Slide slide = slideBuilder.build();
                presentation.appendSlide(slide);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IOException("Error loading file: " + filename, e);
        } catch (ImageLoadingException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadSlideItem(SlideBuilder slideBuilder, Element item) throws ImageLoadingException {
        int level = 1; // default
        NamedNodeMap attributes = item.getAttributes();
        String levelText = attributes.getNamedItem(LEVEL).getTextContent();
        if (levelText != null) {
            try {
                level = Integer.parseInt(levelText);
            } catch (NumberFormatException e) {
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

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException {
        ValidationUtils.checkNotNull(presentation, "Cannot save presentation if nothing is passed");
        ValidationUtils.checkNotNull(filename, "Missing file name to save");

        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("<?xml version=\"1.0\"?>");
            out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
            out.println("<presentation>");
            out.print("<showtitle>");
            out.print(presentation.getTitle());
            out.println("</showtitle>");
            for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
                Slide slide = presentation.getSlide(slideNumber);
                out.println("<slide>");
                out.println("<title>" + slide.getTitle() + "</title>");
                List<SlideItem> slideItems = slide.getSlideItems();
                for (SlideItem slideItem : slideItems) {
                    out.print("<item kind=");
                    if (slideItem instanceof TextItem) {
                        out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
                        out.print(slideItem.getText());
                    } else if (slideItem instanceof BitmapItem) {
                        out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
                        out.print(((BitmapItem) slideItem).getImageName());
                    } else {
                        System.err.println("Ignoring " + slideItem);
                    }
                    out.println("</item>");
                }
                out.println("</slide>");
            }
            out.println("</presentation>");
        }
    }
}
