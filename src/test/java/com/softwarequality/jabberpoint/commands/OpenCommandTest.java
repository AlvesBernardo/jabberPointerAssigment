//package com.softwarequality.jabberpoint.commands;
//
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.Accessor;
//import com.softwarequality.jabberpoint.Constants;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class OpenCommandTest {
//
//    private Presentation presentation;
//    private Frame parent;
//    private Accessor accessor;
//    private Constants constants;
//    private OpenCommand openCommand;
//
//    @BeforeEach
//    void setUp() {
//        presentation = new Presentation();
//        parent = new Frame();
//
//        accessor = new Accessor() {
//            @Override
//            public void loadFile(Presentation presentation, String filename) throws IOException {
//                if ("testfile.txt".equals(filename)) {
//                    // Simulate loading a file
//                } else {
//                    throw new IOException("Test IOException");
//                }
//            }
//
//            @Override
//            public void saveFile(Presentation p, String fn) throws IOException {
//
//            }
//        };
//
//        constants = new Constants("mock") {
//            @Override
//            public String getValue(String key) {
//                switch (key) {
//                    case "TESTFILE":
//                        return "testfile.txt";
//                    case "IOEX":
//                        return "IOException";
//                    case "LOADERR":
//                        return "Load Error";
//                    default:
//                        return "";
//                }
//            }
//        };
//
//        openCommand = new OpenCommand(presentation, parent, accessor, constants);
//    }
//
//    @Test
//    void testExecute() {
//        openCommand.execute();
//        assertEquals(0, presentation.getSlideNumber());
//        parent.repaint();
//    }
//
//    @Test
//    void testExecuteIOException() {
//        accessor = new Accessor() {
//            @Override
//            public void loadFile(Presentation presentation, String filename) throws IOException {
//                throw new IOException("Test IOException");
//            }
//
//            @Override
//            public void saveFile(Presentation p, String fn) throws IOException {
//
//            }
//        };
//
//        constants = new Constants("mock") {
//            @Override
//            public String getValue(String key) {
//                switch (key) {
//                    case "TESTFILE":
//                        return "invalidfile.txt";
//                    case "IOEX":
//                        return "IOException";
//                    case "LOADERR":
//                        return "Load Error";
//                    default:
//                        return "";
//                }
//            }
//        };
//
//        openCommand = new OpenCommand(presentation, parent, accessor, constants);
//
//        openCommand.execute();
//        assertEquals(0, presentation.getSlideNumber());
//    }
//}
