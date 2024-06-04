//package com.softwarequality.jabberpoint;
//
//import com.softwarequality.jabberpoint.drawer.TextItem;
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.slide.Slide;
//import com.softwarequality.jabberpoint.slide.SlideItem;
//import com.softwarequality.jabberpoint.utils.ImageLoadingException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.File;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//class XMLAccessorTest {
//
//    private XMLAccessor xmlAccessor;
//
//    @Mock
//    private Presentation presentationMock;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        xmlAccessor = new XMLAccessor();
//    }
//
//    @Test
//    void testLoadFile() throws IOException, ImageLoadingException {
//        String filename = "test.xml";
//        Presentation presentation = new Presentation();
//        when(presentationMock.getTitle()).thenReturn("Test Presentation");
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document document = db.newDocument();
//        Element root = document.createElement("presentation");
//        Element showTitle = document.createElement("showtitle");
//        showTitle.setTextContent("Test Presentation");
//        root.appendChild(showTitle);
//
//        Element slide = document.createElement("slide");
//        Element slideTitle = document.createElement("title");
//        slideTitle.setTextContent("Slide 1");
//        slide.appendChild(slideTitle);
//
//        Element item = document.createElement("item");
//        item.setAttribute("kind", "text");
//        item.setAttribute("level", "1");
//        item.setTextContent("Text Item");
//        slide.appendChild(item);
//
//        root.appendChild(slide);
//        document.appendChild(root);
//
//        when(presentationMock.getSize()).thenReturn(1);
//        when(presentationMock.getSlide(0)).thenReturn(new Slide("Slide 1"));
//        when(presentationMock.getSlideItems(0)).thenReturn(new SlideItem[]{});
//
//        xmlAccessor.loadFile(presentationMock, filename);
//
//        verify(presentationMock).setTitle("Test Presentation");
//        verify(presentationMock).appendSlide(any(Slide.class));
//        verify(presentationMock).getSlide(0);
//        verify(presentationMock).getSlideItems(0);
//    }
//
//    @Test
//    void testSaveFile() throws IOException {
//        String filename = "test_output.xml";
//        Presentation presentation = new Presentation();
//        presentation.setTitle("Test Presentation");
//        Slide slide = new Slide("Slide 1");
//        slide.appendItem(new TextItem(1, "Text Item"));
//        presentation.appendSlide(slide);
//
//        xmlAccessor.saveFile(presentation, filename);
//
//        File file = new File(filename);
//        assertTrue(file.exists());
//        file.delete();
//    }
//}
