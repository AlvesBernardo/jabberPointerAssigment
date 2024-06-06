package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class XMLAccessorTest {
    @Spy
    XMLAccessor xmlAccessor;
    @Mock
    private DocumentBuilderFactory dbFactory;
    @Mock
    private DocumentBuilder dBuilder;
    @Mock
    private Document doc;
    @Mock
    private Element element, item;
    @Mock
    private NodeList nodeList, slideItems;
    @Mock
    private NamedNodeMap namedNodeMap;
    private Presentation presentation;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presentation = mock(Presentation.class);
        xmlAccessor = new XMLAccessor();
    }

    @Test
    void saveFile_withValidPresentation_ShouldNotThrowException() {
        String saveFilePath = "src/test/resources/saved-presentation.xml";
        assertDoesNotThrow(() -> xmlAccessor.saveFile(new Presentation(), saveFilePath));
    }


    @Test
    public void testLoadFile_withParserConfigurationException() throws Exception {
        DocumentBuilderFactory factory = mock(DocumentBuilderFactory.class);
        when(factory.newDocumentBuilder()).thenThrow(new ParserConfigurationException());

        assertThrows(IOException.class, () -> {
            xmlAccessor.loadFile(presentation, "testfile.xml");
        });
    }

    @Test
    public void testLoadFile_withSAXException() throws Exception {
        DocumentBuilder builder = mock(DocumentBuilder.class);
        when(builder.parse(any(File.class))).thenThrow(new SAXException());

        assertThrows(IOException.class, () -> {
            xmlAccessor.loadFile(presentation, "testfile.xml");
        });
    }

    @Test
    public void testLoadFile_withIOException() throws Exception {
        DocumentBuilder builder = mock(DocumentBuilder.class);
        when(builder.parse(any(File.class))).thenThrow(new IOException());

        assertThrows(IOException.class, () -> {
            xmlAccessor.loadFile(presentation, "testfile.xml");
        });
    }

    private DocumentBuilder mockDocumentBuilder(String kind, String content, String level) throws Exception {
        DocumentBuilderFactory factory = mock(DocumentBuilderFactory.class);
        DocumentBuilder builder = mock(DocumentBuilder.class);
        Document document = mock(Document.class);
        Element docElement = mock(Element.class);
        NodeList slideNodes = mock(NodeList.class);
        NodeList itemNodes = mock(NodeList.class);
        Element slideElement = mock(Element.class);
        Element itemElement = mock(Element.class);
        NamedNodeMap attributes = mock(NamedNodeMap.class);

        when(factory.newDocumentBuilder()).thenReturn(builder);
        when(builder.parse(any(File.class))).thenReturn(document);
        when(document.getDocumentElement()).thenReturn(docElement);
        when(docElement.getElementsByTagName("showtitle")).thenReturn(mockNodeListWithSingleElement("Test Title"));
        when(docElement.getElementsByTagName("slide")).thenReturn(slideNodes);
        when(slideNodes.getLength()).thenReturn(1);
        when(slideNodes.item(0)).thenReturn(slideElement);
        when(slideElement.getElementsByTagName("title")).thenReturn(mockNodeListWithSingleElement("Slide 1"));
        when(slideElement.getElementsByTagName("item")).thenReturn(itemNodes);
        when(itemNodes.getLength()).thenReturn(1);
        when(itemNodes.item(0)).thenReturn(itemElement);
        when(itemElement.getAttributes()).thenReturn(attributes);
        when(attributes.getNamedItem("level")).thenReturn(mockAttr(level));
        when(attributes.getNamedItem("kind")).thenReturn(mockAttr(kind));
        when(itemElement.getTextContent()).thenReturn(content);

        return builder;
    }

    private Element mockAttr(String value) {
        Element attr = mock(Element.class);
        when(attr.getTextContent()).thenReturn(value);
        return attr;
    }

    private NodeList mockNodeListWithSingleElement(String textContent) {
        NodeList nodeList = mock(NodeList.class);
        Element element = mock(Element.class);
        when(nodeList.getLength()).thenReturn(1);
        when(nodeList.item(0)).thenReturn(element);
        when(element.getTextContent()).thenReturn(textContent);
        return nodeList;
    }
}
