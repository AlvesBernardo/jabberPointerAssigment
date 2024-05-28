package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.Accessor;
import com.softwarequality.jabberpoint.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand extends AbstractCommand {
    private final Frame parent;
    private final Accessor accessor;
    private final Constants constants;

    public SaveCommand(Presentation presentation, Frame parent, Accessor accessor, Constants constants) {
        super(presentation);
        this.parent = parent;
        this.accessor = accessor;
        this.constants = constants;
    }

    @Override
    public void execute() {
        try {
            accessor.saveFile(presentation, constants.getValue("SAVEFILE"));
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, constants.getValue("IOEX") + exc, constants.getValue("SAVEERR"), JOptionPane.ERROR_MESSAGE);
        }
    }
}
