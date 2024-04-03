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
        return presentation;
    }

    public void execute()
    {
        presentation.exit();
    }
}
