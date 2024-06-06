package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand extends AbstractCommand {
    private final Frame parent;
    private final Accessor accessor;
    private final Constants constants;

    public OpenCommand(Presentation presentation, Frame parent, Accessor accessor, Constants constants) {
        super(presentation);
        this.parent = parent;
        this.accessor = accessor;
        this.constants = constants;
    }

    @Override
    public void execute() {
        presentation.clear();
        try {
            accessor.loadFile(presentation, constants.getValue("TESTFILE"));
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, constants.getValue("IOEX") + exc, constants.getValue("LOADERR"), JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}
