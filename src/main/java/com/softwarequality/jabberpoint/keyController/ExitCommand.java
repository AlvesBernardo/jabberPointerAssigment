package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;

class ExitCommand implements Command
{
    private final PresentationFacade presentation;

    public ExitCommand(PresentationFacade pres)
    {
        this.presentation = pres;
    }

    public void execute()
    {
        presentation.exit();
    }
}
