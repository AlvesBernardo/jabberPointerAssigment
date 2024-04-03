package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.Presentation;

class ExitCommand implements Command {
    private final Presentation presentation;

    public ExitCommand(Presentation pres) {
        this.presentation = pres;
    }

    public void execute() {
        System.exit(0);
    }
}
