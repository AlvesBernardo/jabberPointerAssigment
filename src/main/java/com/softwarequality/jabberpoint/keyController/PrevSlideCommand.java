package com.softwarequality.jabberpoint.keyController;


import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class PrevSlideCommand implements Command {
    private final PresentationFacade presentation;

    public PrevSlideCommand(PresentationFacade pres) {
        this.presentation = pres;
    }

    public void execute() {
        presentation.previousSlide();
    }
}
