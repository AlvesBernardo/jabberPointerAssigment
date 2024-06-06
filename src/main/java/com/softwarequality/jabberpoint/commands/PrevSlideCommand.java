package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;

class PrevSlideCommand extends AbstractCommand {
    public PrevSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        presentation.prevSlide();
    }
}
