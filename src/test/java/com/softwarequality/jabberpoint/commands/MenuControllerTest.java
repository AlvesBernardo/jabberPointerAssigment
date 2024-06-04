//package com.softwarequality.jabberpoint.commands;
//
//import com.softwarequality.jabberpoint.Constants;
//import com.softwarequality.jabberpoint.XMLAccessor;
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.awt.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//import java.awt.event.ActionEvent;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.Map;
//
//public class MenuControllerTest {
//    private Frame parentMock;
//    private Presentation presentationMock;
//    private XMLAccessor xmlAccessorMock;
//    private Constants constantsMock;
//    private MenuController menuController;
//
//    @BeforeEach
//    void setUp() {
//        parentMock = mock(Frame.class);
//        presentationMock = mock(Presentation.class);
//        xmlAccessorMock = mock(XMLAccessor.class);
//        constantsMock = mock(Constants.class);
//        when(constantsMock.getValue(anyString())).thenReturn("test");
//
//        menuController = new MenuController(parentMock, presentationMock);
//    }
//
//    @SuppressWarnings("unchecked")
//    @Test
//    void testInitializeCommands() throws NoSuchFieldException, IllegalAccessException {
//        Field commandsField = MenuController.class.getDeclaredField("commands");
//        commandsField.setAccessible(true);
//        Map<String, Command> commands = (Map<String, Command>) commandsField.get(menuController);
//
//        assertNotNull(commands.get("OPEN"));
//        assertNotNull(commands.get("NEW"));
//        assertNotNull(commands.get("SAVE"));
//        assertNotNull(commands.get("GOTO"));
//    }
//
//    @Test
//    void testCreateFileMenu() throws Exception {
//        Method createFileMenuMethod = MenuController.class.getDeclaredMethod("createFileMenu");
//        createFileMenuMethod.setAccessible(true);
//        Menu fileMenu = (Menu) createFileMenuMethod.invoke(menuController);
//
//        assertEquals(5, fileMenu.getItemCount());
//
//        assertEquals("Open", fileMenu.getItem(0).getLabel());
//        assertEquals("New", fileMenu.getItem(1).getLabel());
//        assertEquals("Save", fileMenu.getItem(2).getLabel());
//        assertEquals("-", fileMenu.getItem(3).getLabel());
//        assertEquals("Exit", fileMenu.getItem(4).getLabel());
//
//        // Test action listeners for file menu items
//        fileMenu.getItem(4).getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//        verify(parentMock).dispose();
//    }
//
//    @Test
//    void testCreateViewMenu() throws Exception {
//        Method createViewMenuMethod = MenuController.class.getDeclaredMethod("createViewMenu");
//        createViewMenuMethod.setAccessible(true);
//        Menu viewMenu = (Menu) createViewMenuMethod.invoke(menuController);
//
//        assertEquals(3, viewMenu.getItemCount());
//
//        assertEquals("Next", viewMenu.getItem(0).getLabel());
//        assertEquals("Prev", viewMenu.getItem(1).getLabel());
//        assertEquals("Goto", viewMenu.getItem(2).getLabel());
//
//        // Test action listeners for view menu items
//        viewMenu.getItem(0).getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//        verify(presentationMock).nextSlide();
//
//        viewMenu.getItem(1).getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//        verify(presentationMock).prevSlide();
//    }
//
//    @Test
//    void testCreateHelpMenu() throws Exception {
//        Method createHelpMenuMethod = MenuController.class.getDeclaredMethod("createHelpMenu");
//        createHelpMenuMethod.setAccessible(true);
//        Menu helpMenu = (Menu) createHelpMenuMethod.invoke(menuController);
//
//        assertEquals(1, helpMenu.getItemCount());
//        assertEquals("About", helpMenu.getItem(0).getLabel());
//
//        // Mock the AboutBox class and its show method
//        try (var aboutBoxMockedStatic = mockStatic(AboutBox.class)) {
//            // Test action listener for help menu item
//            helpMenu.getItem(0).getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//            aboutBoxMockedStatic.verify(() -> AboutBox.show(parentMock));
//        }
//    }
//
//    @Test
//    void testCreateMenuItem() throws Exception {
//        Command commandMock = mock(Command.class);
//        Method createMenuItemMethod = MenuController.class.getDeclaredMethod("createMenuItem", String.class, Command.class);
//        createMenuItemMethod.setAccessible(true);
//        MenuItem menuItem = (MenuItem) createMenuItemMethod.invoke(menuController, "Test", commandMock);
//
//        assertEquals("Test", menuItem.getLabel());
//
//        menuItem.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//        verify(commandMock).execute();
//    }
//}
