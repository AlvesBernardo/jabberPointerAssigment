package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter {
  private final Map<Integer, Command> keyCommands = new HashMap<>();

  public KeyController(Presentation presentation) {
    ValidationUtils.checkNotNull(presentation, "Presentation cannot be null.");
    initializeCommands(presentation);
  }

  private void initializeCommands(Presentation presentation) {
    keyCommands.put(KeyEvent.VK_PAGE_DOWN, new NextSlideCommand(presentation));
    keyCommands.put(KeyEvent.VK_DOWN, new NextSlideCommand(presentation));
    keyCommands.put(KeyEvent.VK_ENTER, new NextSlideCommand(presentation));
    keyCommands.put((int) '+', new NextSlideCommand(presentation));
    keyCommands.put(KeyEvent.VK_PAGE_UP, new PrevSlideCommand(presentation));
    keyCommands.put(KeyEvent.VK_UP, new PrevSlideCommand(presentation));
    keyCommands.put((int) '-', new PrevSlideCommand(presentation));
    keyCommands.put((int) 'q', new ExitCommand(presentation));
    keyCommands.put((int) 'Q', new ExitCommand(presentation));
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    Command command = keyCommands.get(keyEvent.getKeyCode());
    if (command != null) {
      command.execute();
    }
  }
}
