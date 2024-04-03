package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.Presentation;

class NextSlideCommand implements Command {
    private final Presentation presentation;

    public NextSlideCommand(Presentation pres) {
        this.presentation = pres;
    }

    public void execute() {
        presentation.nextSlide();
    }
}
