package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

class NextSlideCommand extends AbstractCommand {
    public NextSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.nextSlide();
    }
}
