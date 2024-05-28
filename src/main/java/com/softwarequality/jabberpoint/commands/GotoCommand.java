package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.Constants;

import javax.swing.*;
import java.awt.*;

public class GotoCommand extends AbstractCommand {
    private final Frame parent;
    private final Constants constants;

    public GotoCommand(Presentation presentation, Frame parent, Constants constants) {
        super(presentation);
        this.parent = parent;
        this.constants = constants;
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog(parent, constants.getValue("PAGENR"));
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            if (pageNumber < 1 || pageNumber > presentation.getSize()) {
                JOptionPane.showMessageDialog(parent, "Invalid slide number. Please enter a number between 1 and " + presentation.getSize() + ".", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                presentation.setSlideNumber(pageNumber - 1);
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(parent, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
