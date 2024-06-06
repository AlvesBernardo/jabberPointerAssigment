package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.utils.ValidationUtils;

import javax.swing.*;
import java.awt.*;

public class AboutBox {
  public static void show(Frame parent) {
    ValidationUtils.checkNotNull(parent, "Missing parent in about box");

    String message = """
                JabberPoint is a primitive slide-show program in Java(tm). It
                is freely copyable as long as you keep this notice and
                the splash screen intact.
                Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.
                Adapted by Gert Florijn (version 1.1) and 
                Sylvia Stuurman (version 1.2 and higher) for the Open
                University of the Netherlands, 2002 -- now.
                Author's version available from https://www.darwinsys.com/""";
    JOptionPane.showMessageDialog(parent, message, "About JabberPoint", JOptionPane.INFORMATION_MESSAGE);
  }
}
