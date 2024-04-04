package com.softwarequality.jabberpoint.keyController;

import com.softwarequality.jabberpoint.presentation.PresentationFacade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter
{
    private final Map<Integer, Command> keyCommands = new HashMap<>();

    public KeyController(PresentationFacade presentationFacade)
    {
        if (presentationFacade == null)
        {
            throw new IllegalArgumentException("Missing presentation face in key Controller");
        }
        this.keyCommands.put(KeyEvent.VK_PAGE_DOWN, new NextSlideCommand(presentationFacade));
        this.keyCommands.put(KeyEvent.VK_DOWN, new NextSlideCommand(presentationFacade));
        this.keyCommands.put(KeyEvent.VK_ENTER, new NextSlideCommand(presentationFacade));
        this.keyCommands.put((int) '+', new NextSlideCommand(presentationFacade));
        this.keyCommands.put(KeyEvent.VK_PAGE_UP, new PrevSlideCommand(presentationFacade));
        this.keyCommands.put(KeyEvent.VK_UP, new PrevSlideCommand(presentationFacade));
        this.keyCommands.put((int) '-', new PrevSlideCommand(presentationFacade));
        this.keyCommands.put((int) 'q', new ExitCommand(presentationFacade));
        this.keyCommands.put((int) 'Q', new ExitCommand(presentationFacade));
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        Command command = keyCommands.get(keyEvent.getKeyCode());
        if (command != null)
        {
            command.execute();
        }
    }
}
