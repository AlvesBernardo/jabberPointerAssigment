package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;

abstract class AbstractCommand implements Command {
    protected final PresentationFacade presentation;

    AbstractCommand(PresentationFacade presentation) {
        if (presentation == null){
            throw new IllegalArgumentException("Missing presentation in command");
        }
        this.presentation = presentation;
    }

    public PresentationFacade getPresentation()
    {
        return this.presentation;
    }
}
