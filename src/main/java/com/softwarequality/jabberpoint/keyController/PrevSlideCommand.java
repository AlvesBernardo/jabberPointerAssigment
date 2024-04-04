package com.softwarequality.jabberpoint.keyController;


import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class PrevSlideCommand implements Command
{
    private final PresentationFacade presentation;

    public PrevSlideCommand(PresentationFacade presentation)
    {
        if (presentation == null){
            throw new IllegalArgumentException("Missing presentation in prev slide command");
        }
        this.presentation = presentation;
    }

    public void execute()
    {
        this.presentation.previousSlide();
    }
}
