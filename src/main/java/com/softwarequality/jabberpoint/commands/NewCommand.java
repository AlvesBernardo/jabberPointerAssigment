package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

import java.awt.*;

public class NewCommand extends AbstractCommand {
    private final Frame parent;

    public NewCommand(Presentation presentation, Frame parent) {
        super(presentation);
        this.parent = parent;
    }

    @Override
    public void execute() {
        presentation.clear();
        parent.repaint();
    }
}
