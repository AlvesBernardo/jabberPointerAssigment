package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

class ExitCommand extends AbstractCommand {
    public ExitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.exit();
    }
}
