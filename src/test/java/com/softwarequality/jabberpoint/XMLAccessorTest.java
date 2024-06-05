package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.drawer.TextItem;
import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.utils.ImageLoadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class XMLAccessorTest {

    XMLAccessor xmlAccessor;
    Presentation presentation;

    @BeforeEach
    void setUp() {
        xmlAccessor = new XMLAccessor();
        presentation = new Presentation();
    }

    @Test
    void saveFile_withValidPresentation_ShouldNotThrowException() {
        String saveFilePath = "src/test/resources/saved-presentation.xml";
        assertDoesNotThrow(() -> xmlAccessor.saveFile(presentation, saveFilePath));
    }
}
