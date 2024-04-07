package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class ExitCommand implements Command
{
    private final PresentationFacade presentation;

    public ExitCommand(PresentationFacade presentation)
    {
        if (presentation == null){
            throw new IllegalArgumentException("Missing presentation in exit command");
        }
        this.presentation = presentation;
    }

    public PresentationFacade getPresentation()
    {
        return this.presentation;
    }

    public void execute()
    {
        this.presentation.exit();
    }
}
