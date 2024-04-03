package com.softwarequality.jabberpoint.keyController;


import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class NextSlideCommand implements Command {
    private final PresentationFacade presentation;

    public NextSlideCommand(PresentationFacade pres) {
        this.presentation = pres;
    }

    public void execute() {
        presentation.nextSlide();
    }
}
