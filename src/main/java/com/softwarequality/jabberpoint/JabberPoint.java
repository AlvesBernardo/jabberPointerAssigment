package com.softwarequality.jabberpoint;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.presentation.PresentationFacade;
import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.slideView.SlideViewerFrame;

import javax.swing.*;
import java.io.IOException;

public class JabberPoint
{
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    public static void main(String[] argv)
    {

        Style.createStyles();
        Presentation presentation = new Presentation();
        PresentationFacade presentationFacade = new PresentationFacade(presentation);
        new SlideViewerFrame(JABVERSION, presentationFacade);
        try
        {
            if (argv.length == 0)
            { // een demo presentatie
                Accessor.getDemoAccessor().loadFile(presentationFacade, "");
            } else
            {
                new XMLAccessor().loadFile(presentationFacade, argv[0]);
            }
            presentation.setSlideNumber(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                    IOERR + ex, JABERR,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
