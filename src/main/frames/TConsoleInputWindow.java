package main.frames;

import main.components.TConsoleTextAreaInputWindow;
import main.components.TConsoleTextAreaMainWindow;
import main.components.component_bridge.TConsoleComponentBridge;
import main.listeners.key.TCKeyListener;
import main.patterns.TConsoleJFramePattern;
import main.util.ready.TConsoleReady;
import run.TConsoleRunner;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TConsoleInputWindow extends TConsoleJFramePattern {
    protected static   TConsoleTextAreaInputWindow textAreaInputWindow;

    public static TConsoleTextAreaInputWindow getTextAreaInputWindow() {
        return textAreaInputWindow;
    }

    public TConsoleInputWindow(String TITLE) {
        super(TITLE);

    }

    @Override
    public void settings() {
        this.setSize(TConsoleRunner.console.getWidth(),75);
        this.setPreferredSize(new Dimension(TConsoleReady.getInputConsoleWidth(),75));
        this.pack();
        this.setResizable(false);

        super.settings();
    }


    @Override
    public void add() {
        TConsoleTextAreaInputWindow inputWindow = new TConsoleTextAreaInputWindow();
        textAreaInputWindow = inputWindow;
        this.add(inputWindow);
        super.add();
    }

    @Override
    public void settings_listeners_key() {
        super.settings_listeners_key();
    }

    @Override
    public void setListener(KeyListener listener) {
        super.setListener(new TCKeyListener());
    }

    @Override
    public void refresh() {
        super.refresh();
    }
}
