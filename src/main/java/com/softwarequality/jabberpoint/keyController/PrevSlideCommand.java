package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.Presentation;

class PrevSlideCommand implements Command {
    private final Presentation presentation;

    public PrevSlideCommand(Presentation pres) {
        this.presentation = pres;
    }

    public void execute() {
        presentation.prevSlide();
    }
}
