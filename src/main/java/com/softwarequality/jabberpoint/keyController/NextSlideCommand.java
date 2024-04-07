package com.softwarequality.jabberpoint.keyController;


import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class NextSlideCommand implements Command
{
    private final PresentationFacade presentation;

    public NextSlideCommand(PresentationFacade presentation)
    {
        if (presentation == null)
        {
            throw new IllegalArgumentException("Missing presentation in next slide command");
        }
        this.presentation = presentation;
    }

    public void execute()
    {
        this.presentation.nextSlide();
    }
}
