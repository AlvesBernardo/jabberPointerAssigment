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
        String pageNumberStr = requestPageInput();

        if(!isPageNumberValid(pageNumberStr)) {
            showErrorMessage("Please enter a valid number.");
            return;
        }

        int pageNumber = Integer.parseInt(pageNumberStr);

        if(!isPageWithinRange(pageNumber)) {
            showErrorMessage("Invalid slide number. Please enter a number between 1 and " + presentation.getSize() + ".");
            return;
        }

        presentation.setSlideNumber(pageNumber - 1);
    }

    private String requestPageInput() {
        return JOptionPane.showInputDialog(parent, constants.getValue("PAGENR"));
    }

    private boolean isPageNumberValid(String pageNumberStr) {
        return pageNumberStr.matches("\\d+");
    }

    private boolean isPageWithinRange(int pageNumber) {
        return pageNumber > 0 && pageNumber <= presentation.getSize();
    }

    private void showErrorMessage(String errorMsg) {
        JOptionPane.showMessageDialog(parent, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
