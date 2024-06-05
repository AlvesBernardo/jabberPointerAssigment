//package com.softwarequality.jabberpoint.commands;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class MenuControllerTest {
//    @Mock
//    private Frame parentMock;
//
//    @Mock
//    private Presentation presentationMock;
//
//    private MenuController menuController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        menuController = new MenuController(parentMock, presentationMock);
//    }
//
//    @Test
//    void testCreateMenus() {
//        // We cannot test createMenus directly, so we test its caller method
//        menuController.createMenus();
//
//        // Verify that createFileMenu, createViewMenu, and createHelpMenu were called
//        verify(menuController).createFileMenu();
//        verify(menuController).createViewMenu();
//        verify(menuController).createHelpMenu();
//    }
//
//    @Test
//    void testCreateFileMenu() throws Exception {
//        Menu fileMenu = menuController.createFileMenu();
//
//        assertEquals(5, fileMenu.getItemCount());
//
//        // Test "Exit" action listener
//        ActionEvent mockActionEvent = mock(ActionEvent.class);
//        fileMenu.getItem(4).getActionListeners()[0].actionPerformed(mockActionEvent);
//
//        verify(parentMock).dispose();
//    }
//
//    @Test
//    void testCreateViewMenu() throws Exception {
//        Menu viewMenu = menuController.createViewMenu();
//
//        assertEquals(3, viewMenu.getItemCount());
//
//        // Test "Next" action listener
//        ActionEvent mockActionEventNext = mock(ActionEvent.class);
//        viewMenu.getItem(0).getActionListeners()[0].actionPerformed(mockActionEventNext);
//        verify(presentationMock).nextSlide();
//
//        // Test "Prev" action listener
//        ActionEvent mockActionEventPrev = mock(ActionEvent.class);
//        viewMenu.getItem(1).getActionListeners()[0].actionPerformed(mockActionEventPrev);
//        verify(presentationMock).prevSlide();
//    }
//
//    @Test
//    void testCreateHelpMenu() throws Exception {
//        Menu helpMenu = menuController.createHelpMenu();
//
//        assertEquals(1, helpMenu.getItemCount());
//
//        // Test "About" action listener
//        ActionEvent mockActionEvent = mock(ActionEvent.class);
//        helpMenu.getItem(0).getActionListeners()[0].actionPerformed(mockActionEvent);
//
//        verify(AboutBox.class).show(parentMock);
//    }
//}
