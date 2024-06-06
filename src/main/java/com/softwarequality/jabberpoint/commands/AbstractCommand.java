package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

abstract class AbstractCommand implements Command {
    protected final Presentation presentation;

    AbstractCommand(Presentation presentation) {
        ValidationUtils.checkNotNull(presentation, "Presentation cannot be null.");
        this.presentation = presentation;
    }
}
