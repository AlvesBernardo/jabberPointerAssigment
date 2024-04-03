package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Slide;
import com.softwarequality.jabberpoint.slide.SlideBuilder;
import com.softwarequality.jabberpoint.slide.TextItem;

class DemoPresentation extends Accessor
{

    public void loadFile(PresentationFacade presentation, String unusedFilename)
    {

        presentation.setTitle("Demo Presentation");
        Slide slide1 = new SlideBuilder()
                .withTitle("JabberPoint")
                .appendItem(new TextItem(1, "The Java Presentation Tool"))
                .appendItem(new TextItem(2, "Copyright (c) 1996-2000: Ian Darwin"))
                .appendItem(new TextItem(2, "Copyright (c) 2000-now:"))
                .appendItem(new TextItem(2, "Gert Florijn and Sylvia Stuurman"))
                .appendItem(new TextItem(4, "Starting JabberPoint without a filename"))
                .appendItem(new TextItem(4, "shows this presentation"))
                .appendItem(new TextItem(1, "Navigate:"))
                .appendItem(new TextItem(3, "Next slide: PgDn or Enter"))
                .appendItem(new TextItem(3, "Previous slide: PgUp or up-arrow"))
                .appendItem(new TextItem(3, "Quit: q or Q"))
                .build();

        presentation.appendSlide(slide1);

        Slide slide2 = new SlideBuilder()
                .withTitle("Demonstration of levels and styles")
                .appendItem(new TextItem(1, "Level 1"))
                .appendItem(new TextItem(2, "Level 2"))
                .appendItem(new TextItem(1, "Again level 1"))
                .appendItem(new TextItem(1, "Level 1 has style number 1"))
                .appendItem(new TextItem(2, "Level 2 has style number  2"))
                .appendItem(new TextItem(3, "This is how level 3 looks like"))
                .appendItem(new TextItem(4, "And this is level 4"))
                .build();

        presentation.appendSlide(slide2);

        Slide slide3 = new SlideBuilder()
                .withTitle("The third slide")
                .appendItem(new TextItem(1, "To open a new presentation,"))
                .appendItem(new TextItem(2, "use File->Open from the menu."))
                .appendItem(new TextItem(1, " "))
                .appendItem(new TextItem(1, "This is the end of the presentation."))
                .build();

        presentation.appendSlide(slide3);
    }

    public void saveFile(PresentationFacade presentation, String unusedFilename)
    {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
