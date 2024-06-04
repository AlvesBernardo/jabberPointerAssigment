//package com.softwarequality.jabberpoint.commands;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.awt.*;
//
//import static org.mockito.Mockito.verify;
//@ExtendWith(MockitoExtension.class) //
//public class NewCommandTest {
//
//    @Mock
//    private Presentation presentationMock;
//
//    @Mock
//    private Frame parentMock;
//
//    private NewCommand newCommand;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        newCommand = new NewCommand(presentationMock, parentMock);
//    }
//
//    @Test
//    void testExecute() {
//        newCommand.execute();
//        verify(presentationMock).clear();
//        verify(parentMock).repaint();
//    }
//}
